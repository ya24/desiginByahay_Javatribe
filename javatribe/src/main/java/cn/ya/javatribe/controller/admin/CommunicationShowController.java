package cn.ya.javatribe.controller.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.admin.User;
import cn.ya.javatribe.model.generator.CommunicationMeeting;
import cn.ya.javatribe.service.admin.CommunicationShowService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 叶雅芳 on 2017/4/7.
 * 交流会风采的控制层
 */
@Controller
public class CommunicationShowController {

    @Autowired
    private CommunicationShowService communicationShowService;

    @RequestMapping("/showCommunication")
    public String showCommunication(){
        return "admin/communicationShow/communicationShow";
    }

    // 交流会风采编辑显示
    @RequestMapping(value = "/createCommunicationShow", method = {RequestMethod.GET})
    @RequiresPermissions("communicationShow:create")
    public String showCommunicationShow(){
        return "admin/communicationShow/createCommunicationShow";
    }

    // 交流会风采编辑之——图片上传，此方法仅做上传图片，同时返回图片的访问路径。
    @RequestMapping("/uploadCommunicationShowImg")
    public void uploadCommunicationShowImg(HttpServletRequest request, HttpServletResponse response){

        // 上传三步
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        List<FileItem> fileItemList;

        try {
            fileItemList = servletFileUpload.parseRequest(request);
            // 处理文件表单项
            for (FileItem fileItem : fileItemList){
                if (!fileItem.isFormField()){
                    String fileName = fileItem.getName();
                    // 如果没有上传文件，跳出本循环
                    if (fileName == null || fileName.isEmpty()){
                        continue;
                    }
                    // 浏览器原因，截取文件名称
                    int index = fileName.lastIndexOf("\\");
                    if (index != -1){
                        fileName = fileName.substring(index+1);
                    }
                    // 文件名防止重名处理
                    fileName = UUID.randomUUID().toString().replace("-","").toUpperCase() + "_" + fileName;

                    // 文件保存路径
                    String savePath = request.getServletContext().getRealPath("/static/img/communicationShowImg");
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dir = simpleDateFormat.format(date).replace("-","");
                    savePath = savePath + "\\" + dir;

                    // 创建保存目录
                    File savePahtFile = new File(savePath);
                    if (!savePahtFile.exists()){
                        savePahtFile.mkdirs();
                    }

                    // 上传文件
                    fileItem.write(new File(savePath, fileName));

                    // 获取图片url地址
                    String imgURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "" + request.getContextPath()
                            + "/static/img/communicationShowImg/" + dir + "/" + fileName;
                    // 返回url地址
                    PrintWriter out = response.getWriter();
                    out.write(imgURL);
                    out.flush();
                    out.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 交流会风采公布
    @RequestMapping(value = "/createCommunicationShow", method = {RequestMethod.POST})
    @RequiresPermissions("communicationShow:create")
    public String createCommunicationShow(CommunicationMeeting communicationMeeting, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        communicationMeeting.setMemberName(user.getUserName());
        int result = communicationShowService.insertCommunicationMeetiong(communicationMeeting);
        if (result == 1){
            request.setAttribute("status","交流会风采编辑成功");
        }else {
            request.setAttribute("status","交流会风采编辑失败");
        }
        return "status";
    }

    // 交流会展览
    @RequestMapping("/queryCommunicationShow/{currentPage}")
    @RequiresPermissions("communicationShow:query")
    public String queryCommunicationShow(@PathVariable("currentPage")Integer currentPage, Model model){
        Page<CommunicationMeeting> communicationMeetingPage = communicationShowService.queryCommunicationShowByLimit(currentPage);
        communicationMeetingPage.setUrl("/queryCommunicationShow");
        model.addAttribute("communicationMeetingPage", communicationMeetingPage);
        return "admin/communicationShow/communicationShowList";
    }

    // 交流会风采详情
    @RequestMapping("/communicationShowDetail/{meetingId}")
    @RequiresPermissions("communicationShow:query")
    public String communicationShowDetail(@PathVariable("meetingId")Integer meetingId, Model model){
        CommunicationMeeting communicationMeeting = communicationShowService.queryCommunicationShowById(meetingId);
        model.addAttribute("communicationMeeting", communicationMeeting);
        return "admin/communicationShow/communicationShowDetail";
    }

    // 交流会风采修改页面的显示
    @RequestMapping(value = "/updateCommunicationShow/{meetingId}", method = {RequestMethod.GET})
    @RequiresPermissions("communicationShow:update")
    public String showUpdateCommunicationShow(@PathVariable("meetingId")Integer meetingId, HttpServletRequest request, Model model){
        CommunicationMeeting communicationMeeting = communicationShowService.queryCommunicationShowById(meetingId);
        User user = (User)request.getSession().getAttribute("user");
        if (user.getRoleId() == 4 && !user.getUserName().equals(communicationMeeting.getMemberName())){
            request.setAttribute("status","您没有修改交流会风采内容的权限");
            return "status";
        }
        model.addAttribute("communicationMeeting", communicationMeeting);
        return "admin/communicationShow/updateCommunicationShow";
    }

    // 交流会风采修改
    @RequestMapping(value = "/updateCommunicationShow", method = {RequestMethod.POST})
    @RequiresPermissions("communicationShow:update")
    public String updateCommunicationShow(CommunicationMeeting communicationMeeting, HttpServletRequest request){
        int result = communicationShowService.updateCommunicationMeeting(communicationMeeting);
        if (result == 1){
            request.setAttribute("status","交流会风采内容修改成功");
        }else {
            request.setAttribute("status","交流会风采内容修改失败");
        }
        return "status";
    }

    // 交流会风采删除
    @RequestMapping("/deleteCommunicationShow/{meetingId}")
    @RequiresPermissions("communicationShow:delete")
    public String delCommunicationShow(@PathVariable("meetingId")Integer meetingId, HttpServletRequest request){

        CommunicationMeeting communicationMeeting = communicationShowService.queryCommunicationShowById(meetingId);
        User user = (User)request.getSession().getAttribute("user");

        if (user.getRoleId() == 4 && !user.getUserName().equals(communicationMeeting.getMemberName())){
            request.setAttribute("status","您没有删除此交流会风采内容的权限");
            return "status";
        }

        if (communicationShowService.delCommunicationMeeting(meetingId) == 1){
            request.setAttribute("status","删除交流会风采成功");
        }else {
            request.setAttribute("status","删除交流会风采失败");
        }
        return "status";
    }
}
