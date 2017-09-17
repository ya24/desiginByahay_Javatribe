package cn.ya.javatribe.controller.admin;

import cn.ya.javatribe.model.admin.User;
import cn.ya.javatribe.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
@Controller
public class UserController {

    //登陆提交地址，和spring-shiro.xml中配置的loginurl一致
    @RequestMapping("/login")
    public String login(HttpServletRequest request)throws Exception{

//        if(request.getSession().getAttribute("user") != null){
//            return "admin/welcome";
//        }

        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                request.setAttribute("error", "账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                request.setAttribute("error", "用户名/密码错误");
            } else if("verifyCodeError".equals(exceptionClassName)){
                request.setAttribute("error", "验证码错误");
            }else {
                request.setAttribute("error", "未知错误");
            }
        }
        //此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登陆失败还到login页面
        return "admin/login";
    }

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        // 取出用户身份信息
        User user = (User) subject.getPrincipal();
        request.getSession().setAttribute("user", user);
        return "admin/welcome";
    }

    @RequestMapping("/body")
    public String body(){
        return "admin/body";
    }


    // 无权限拒绝页
    @RequestMapping("/refuse")
    public String refuse(){
        return "refuse";
    }


    /**
     * 给前端返回一张验证码图片
     */
    @RequestMapping("/verify")
    public void verify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode vc = new VerifyCode();

        // 获取一次性验证码图片
        BufferedImage image = vc.getImage();

        // 把图片写到指定流中（响应到页面）
        VerifyCode.output(image, response.getOutputStream());

        // 把图片文本保存到session中
        request.getSession().setAttribute("sessionVCode", vc.getText());
    }

}
