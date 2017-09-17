package cn.ya.javatribe.controller.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Affiche;
import cn.ya.javatribe.model.generator.Attachfile;
import cn.ya.javatribe.service.admin.AfficheManagerService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

/**
 * Created by 叶雅芳 on 2017/3/31.
 * 公告查询controller，专门做公告查询的处理
 */
@Controller
public class AfficheQueryController {

    @Autowired
    private AfficheManagerService afficheManagerService;

    // 显示公告列表
    @RequestMapping(value = "/queryAffiche/{currentPage}", method = {RequestMethod.GET})
    @RequiresPermissions("affiche:query")
    public String queryAffiche(@PathVariable("currentPage") Integer currentPage, Model model){
        Page<Affiche> affichePage = afficheManagerService.queryAllAfficheByPage(currentPage);
        affichePage.setUrl("/queryAffiche");
        model.addAttribute("affichePage",affichePage);
        return "admin/affiches/afficheList";
    }

    // 公告多条件查询
    @RequestMapping(value = "/queryAffiche", method = {RequestMethod.POST})
    public String queryAfficheBy(Affiche affiche){
        //System.out.println(affiche);

        return "";
    }

    // 公告内容查看
    @RequestMapping("/queryAfficheContent/{afficheId}")
    @RequiresPermissions("affiche:query")
    public String queryAfficheContent(@PathVariable("afficheId")Integer afficheId, Model model){
        Affiche affiche = afficheManagerService.queryAfficheById(afficheId);
        Attachfile attachfile = null;
        if (affiche.getAttachfileId() != null){
            attachfile = afficheManagerService.queryAttachfileById(affiche.getAttachfileId());
        }
        model.addAttribute("affiche",affiche);
        model.addAttribute("attachfile",attachfile);
        return "admin/affiches/afficheDetail";
    }

    // 下载附件
    @RequestMapping(value = "/loadAttachFile/{attachfileId}",method = {RequestMethod.GET})
    @RequiresPermissions("affiche:query")
    public void loadAttachFile(@PathVariable("attachfileId")String attachfileId,
                               HttpServletRequest request, HttpServletResponse response){
        try {
            Attachfile attachfile = afficheManagerService.queryAttachfileById(attachfileId);
            String contentType = request.getServletContext().getMimeType(attachfile.getAttachfileName());
            String contentDisposition = "attachment;filename=" + attachfile.getAttachfileName();
            FileInputStream fileInputStream = new FileInputStream(attachfile.getAttachfilePath());
            response.setHeader("Content-Type", contentType);
            response.setHeader("Content-Disposition", contentDisposition);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            IOUtils.copy(fileInputStream, servletOutputStream);
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
