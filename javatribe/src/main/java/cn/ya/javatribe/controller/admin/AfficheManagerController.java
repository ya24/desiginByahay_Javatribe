package cn.ya.javatribe.controller.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.admin.User;
import cn.ya.javatribe.model.generator.Affiche;
import cn.ya.javatribe.model.generator.Attachfile;
import cn.ya.javatribe.service.admin.AfficheManagerService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.annotation.MultipartConfig;
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
 * Created by 叶雅芳 on 2017/3/27.
 * 公告管理controller，专门处理公告的增删改
 */
@Controller
@MultipartConfig
public class AfficheManagerController {

    @Autowired
    private AfficheManagerService afficheManagerService;

    // 显示公告管理页面
    @RequestMapping("/showAffiche")
    @RequiresPermissions("affiche:admin")
    public String showAffiche(){
        return "admin/affiches/affiche";
    }

    // 显示发布公告页面
    @RequestMapping(value = "/createAffiche", method = {RequestMethod.GET})
    @RequiresPermissions("affiche:create")
    public String showcreateAffiche(){
        return "admin/affiches/createAffiche";
    }

    // 发布公告
    @RequestMapping(value = "/createAffiche", method = {RequestMethod.POST})
    @RequiresPermissions("affiche:create")
    public String createAffiche(HttpServletRequest request){

        Affiche affiche = new Affiche();
        // 创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        // 解析request，得到FileItem
        List<FileItem> fileItemList ;
        try {
            fileItemList  = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItemList){
                if (fileItem.isFormField()){
                    // 普通表单项
                    String fieldName = fileItem.getFieldName(); //表单项名称
                    if (fieldName.equals("afficheTitle")){
                        affiche.setAfficheTitle(fileItem.getString("utf-8"));
                    }else if (fieldName.equals("afficheContent")){
                        affiche.setAfficheContent(fileItem.getString("utf-8"));
                    }
                }else {
                    // 文件表单项

                    //获取上传文件的名称
                    String fileName = fileItem.getName();
                    if (fileName == null || fileName.isEmpty()){
                        continue;   //如果上传文件的文件名称为空，即没有指定上传文件，则进入下一个循环，取其他表单项
                    }
                    // 浏览器的原因，文件名需要做处理
                    int index = fileName.lastIndexOf("\\");
                    if (index != -1){
                        fileName = fileName.substring(index+1);
                    }
                    // 文件名称加前缀
                    fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;


                    // 文件放在WEB-INF下，并且要用时间做目录，还要防止重名加前缀
                    // 获取WEB-INF目录
                    String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFiles");
                    // 时间做目录
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dir = simpleDateFormat.format(date);
                    dir = dir.replace("-","");
                    // 创建目录
                    savePath = savePath + "\\" + dir;

                    File savePathFile = new File(savePath); //目录
                    File file = new File(savePath, fileName);   // 文件全路径
                    if (savePathFile.exists()){
                        // 文件存在直接上传
                        fileItem.write(file);
                    }else{
                        if(new File(savePath).mkdirs()){
                            // 将上传文件存储在指定目录下
                            fileItem.write(file);
                        }else {
                            request.setAttribute("status","公告发布失败-原因是文件未上传成功");
                            return "status";
                        }
                    }

                    // 封装文件路径到公告model对象中
                    // 但要先把附件相关的消息添加到数据库中。
                    Attachfile attachfile = new Attachfile();
                    attachfile.setAttachfileName(fileName);
                    attachfile.setAttachfilePath(savePath + "\\" + fileName);
                    String attachfileId = afficheManagerService.insertAttachfile(attachfile);


                    // 如果附件添加成功，将附件ID存储到公告model对象中
                    if (attachfileId == null){
                        request.setAttribute("status","公告添加失败，原因是附件无法添加");
                        return "status";
                    }
                    affiche.setAttachfileId(attachfileId);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        User user = (User)request.getSession().getAttribute("user");
        affiche.setMemberName(user.getUserName());


        int result = afficheManagerService.insertAffiche(affiche);
        if (result != 1){
            request.setAttribute("status","公告发布失败");
        }
        request.setAttribute("status","公告发布成功");
        return "status";
    }

    // 发起修改公告请求
    @RequestMapping(value = "/updateAffiche/{afficheId}", method = {RequestMethod.GET})
    @RequiresPermissions("affiche:update")
    public String updateAffiche(@PathVariable("afficheId") Integer afficheId,
                                HttpServletRequest request, Model model){

        Affiche affiche = afficheManagerService.queryAfficheById(afficheId);

        User user = (User)request.getSession().getAttribute("user");
        if (user.getRoleId() == 4 && !user.getUserName().equals(affiche.getMemberName())){
            request.setAttribute("status","您没有修改此公告的权限");
            return "status";
        }

        Attachfile attachfile = null;
        if (affiche.getAttachfileId() != null){
            attachfile = afficheManagerService.queryAttachfileById(affiche.getAttachfileId());
        }

        model.addAttribute("affiche",affiche);
        model.addAttribute("attachfile",attachfile);
        return "admin/affiches/updateAffiche";
    }

    // 删除附件
    @RequestMapping(value = "/deleteAttachFile/{attachfileId}")
    @RequiresPermissions("affiche:delete")
    public String deleteAttachFile(@PathVariable("attachfileId")String attachfileId, HttpServletRequest request){

        boolean result = afficheManagerService.deleteAttachFile(attachfileId);
        if (result){
            request.setAttribute("status","附件删除成功");
        }else {
            request.setAttribute("status","附件删除失败");
        }

        return "status";
    }

    // 公告修改
    @RequestMapping(value = "/updateAffiche", method = {RequestMethod.POST})
    @RequiresPermissions("affiche:update")
    public String updatingAffiche(HttpServletRequest request){

        Affiche affiche = new Affiche();

        // 创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        // 解析request，得到FileItem
        List<FileItem> fileItemList ;
        try {
            fileItemList  = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItemList){
                if (fileItem.isFormField()){
                    // 普通表单项
                    String fieldName = fileItem.getFieldName(); //表单项名称
                    if (fieldName.equals("afficheTitle")){
                        affiche.setAfficheTitle(fileItem.getString("utf-8"));
                    }else if (fieldName.equals("afficheContent")){
                        affiche.setAfficheContent(fileItem.getString("utf-8"));
                    }else if (fieldName.equals("memberName")){
                        affiche.setMemberName(fileItem.getString("utf-8"));
                    }
                }else {
                    // 文件表单项

                    //获取上传文件的名称
                    String fileName = fileItem.getName();
                    if (fileName == null || fileName.isEmpty()){
                        continue;   //如果上传文件的文件名称为空，即没有指定上传文件，则进入下一个循环，取其他表单项
                    }
                    // 浏览器的原因，文件名需要做处理
                    int index = fileName.lastIndexOf("\\");
                    if (index != -1){
                        fileName = fileName.substring(index+1);
                    }
                    // 文件名称加前缀
                    fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;
                    // 文件放在WEB-INF下，并且要用时间做目录，还要防止重名加前缀
                    // 获取WEB-INF目录
                    String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFiles");
                    // 时间做目录
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dir = simpleDateFormat.format(date);
                    dir = dir.replace("-","");
                    // 创建目录
                    savePath = savePath + "\\" + dir;

                    File savePathFile = new File(savePath); //目录
                    File file = new File(savePath, fileName);   //文件全路径

                    if (savePathFile.exists()){
                        fileItem.write(file);
                    }else {
                        if(new File(savePath).mkdirs()){
                            // 将上传文件存储在指定目录下
                            fileItem.write(file);
                        }else {
                            request.setAttribute("status","公告修改失败-原因是文件未上传成功");
                            return "status";
                        }
                    }

                    // 封装文件路径到公告model对象中
                    // 但要先把附件相关的消息添加到数据库中。
                    Attachfile attachfile = new Attachfile();
                    attachfile.setAttachfileName(fileName);
                    attachfile.setAttachfilePath(savePath + "\\" + fileName);
                    String attachfileId = afficheManagerService.insertAttachfile(attachfile);

                    // 如果附件添加成功，将附件ID存储到公告model对象中
                    if (attachfileId == null){
                        request.setAttribute("status","公告修改失败，原因是附件无法添加");
                        return "status";
                    }
                    affiche.setAttachfileId(attachfileId);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int result = afficheManagerService.insertAffiche(affiche);
        if (result != 1){
            request.setAttribute("status","公告修改失败");
        }
        request.setAttribute("status","公告修改成功");
        return "status";
    }

    // 删除公告
    @RequestMapping(value = "/deleteAffiche/{afficheId}", method = {RequestMethod.GET})
    @RequiresPermissions("affiche:delete")
    public String deleteAffiche(@PathVariable("afficheId") Integer afficheId, HttpServletRequest request){

        Affiche affiche = afficheManagerService.queryAfficheById(afficheId);


        User user = (User) request.getSession().getAttribute("user");

        if (user.getRoleId() == 4 && !user.getUserName().equals(affiche.getMemberName())){
            request.setAttribute("status","您没有删除此公告的权限");
            return "status";
        }

        int result = afficheManagerService.delAfficheById(afficheId);

        if (result == 1){
            request.setAttribute("status","删除公告成功");
        }else {
            request.setAttribute("status","删除公告失败");
        }

        return "status";
    }
}
