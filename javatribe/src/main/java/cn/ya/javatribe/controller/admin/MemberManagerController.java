package cn.ya.javatribe.controller.admin;

import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.*;
import cn.ya.javatribe.service.admin.MemberManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/23.
 */
@Controller
public class MemberManagerController {

    @Autowired
    private MemberManagerService memberManagerService;

    // 正式成员查询
    @RequestMapping("/queryMembers/{currentPage}")
    @RequiresPermissions("members:query")
    public String queryMembers(Model model, @PathVariable("currentPage") Integer currentPage){
        /*
        (1)	从页面中先获取当前页码
        (2)	然后调用service层的方法，得到分页model
        (3)	解析controller层获取到的请求路径，去掉页面封装在分页model中。
        (4)	然后把分页model传回给页面
         */

        Page<MemberInfo> memberInfoPage = memberManagerService.queryAllMembersByPage(currentPage);

        memberInfoPage.setUrl("/queryMembers");
        model.addAttribute("memberInfoPage", memberInfoPage);
        return "admin/members/memberList";
    }

    // 考核人员查询
    @RequestMapping("/queryExamineMembers/{currentPage}")
    @RequiresPermissions("examineMembers:query")
    public String queryExamineMembers(Model model, @PathVariable("currentPage") Integer currentPage){


        Page<MemberInfo> memberInfoPage = memberManagerService.queryAllExamineMembersByPage(currentPage);
        memberInfoPage.setUrl("/queryExamineMembers");
        model.addAttribute("memberInfoPage", memberInfoPage);
        return "admin/members/examineMemberList";
    }

    // 添加成员之页面显示
    @RequestMapping(value = "/createMembers", method = {RequestMethod.GET})
    @RequiresPermissions("members:create")
    public String showCreateMembers(Model model){
        List<Grade> grades = memberManagerService.queryAllGrade();
        List<TeamGroup> teamGroups = memberManagerService.queryAllTeamGroup();
        List<Role> roles = memberManagerService.queryAllRole();
        List<Duty> duties = memberManagerService.queryAllDuty();
        model.addAttribute("grades", grades);
        model.addAttribute("teamGroups", teamGroups);
        model.addAttribute("roles", roles);
        model.addAttribute("duties", duties);
        return "admin/members/createMembers";
    }

    // 添加成员
    @RequestMapping(value = "/createMembers", method = {RequestMethod.POST})
    @RequiresPermissions("members:create")
    public String createMembers(Model model, TeamMembers teamMembers){

        int result = memberManagerService.insertMembers(teamMembers);
        if (result != 1){
            model.addAttribute("status", "添加成员"+teamMembers.getMemberName()+"失败");

        }
        model.addAttribute("status", "添加"+teamMembers.getMemberName()+"成功");
        return "status";
    }

    // 更新成员页面显示
    @RequestMapping(value = "/updateMembers/{memberId}", method = {RequestMethod.GET})
    @RequiresPermissions("members:update")
    public String showUpdateMembers(Model model, @PathVariable("memberId") Integer memberId){
        TeamMembers teamMembers = memberManagerService.queryMemberById(memberId);
        List<Grade> grades = memberManagerService.queryAllGrade();
        List<TeamGroup> teamGroups = memberManagerService.queryAllTeamGroup();
        List<Role> roles = memberManagerService.queryAllRole();
        List<Duty> duties = memberManagerService.queryAllDuty();

        model.addAttribute("teamMembers", teamMembers);
        model.addAttribute("grades", grades);
        model.addAttribute("teamGroups", teamGroups);
        model.addAttribute("roles", roles);
        model.addAttribute("duties", duties);
        return "admin/members/updateMembers";
    }

    // 更新成员
    @RequestMapping(value = "/updateMembers", method = {RequestMethod.POST})
    @RequiresPermissions("members:update")
    public String updateMembers(Model model, TeamMembers teamMembers){

        int result = memberManagerService.updateMembers(teamMembers);
        if (result != 1){
            model.addAttribute("status", "修改" + teamMembers.getMemberName() + "失败");
        }
        model.addAttribute("status", "修改" + teamMembers.getMemberName() + "成功");
        return "status";
    }

    // 移除成员
    @RequestMapping("/removeMembers/{memberId}")
    @RequiresPermissions("members:delete")
    public String removeMembers(Model model, @PathVariable("memberId") Integer memberId){
        int result = memberManagerService.deleteMemberByPrimaryKey(memberId);
        if (result != 1){
            model.addAttribute("status", "删除" + memberId + "成员失败");
        }
        model.addAttribute("status", "删除" + memberId + "成员成功");
        return "status";
    }
}
