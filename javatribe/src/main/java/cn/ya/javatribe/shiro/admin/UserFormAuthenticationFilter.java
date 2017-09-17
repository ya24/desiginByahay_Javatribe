package cn.ya.javatribe.shiro.admin;

import cn.ya.javatribe.model.admin.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 叶雅芳 on 2017/3/18.
 * 自定义表单认证过滤器，添加对验证码的校验
 */
public class UserFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)){ // 是否是登录URL
            // 获取主体
            Subject subject = getSubject(request, response);
            // 判断主体是否已认证
            if (subject.isAuthenticated()){
                // 已认证则重定向
                HttpServletResponse httpServletResponse = (HttpServletResponse)response;
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                try {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/welcome");
                } catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    //    @Override 同学写的逻辑
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        if (isLoginRequest(request, response)) {
//            Subject subject = getSubject(request, response);
//            if (subject.isAuthenticated()) {
//                try {
//                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/welcome");
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//                return true;
//            }
//        }
//        return super.isAccessAllowed(request, response, mappedValue);
//    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //进行验证码校验
        //从session获取正确验证码
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String sessionVCode = (String) httpServletRequest.getSession().getAttribute("sessionVCode");
        //取出页面的验证码
        String vcode = httpServletRequest.getParameter("vcode");

        // 校验
        if (sessionVCode != null && vcode != null && !sessionVCode.equalsIgnoreCase(vcode)) {
            //如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute("shiroLoginFailure", "verifyCodeError");
            //拒绝访问，不再校验账号和密码
            return true;
        }

        return super.onAccessDenied(request, response);
    }
}
