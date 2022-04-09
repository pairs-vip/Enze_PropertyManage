package com.hbjg.system.interceptor;

import com.hbjg.system.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        try {
//            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
//            User user=(User)request.getSession().getAttribute("user");
//            if(user!=null){
//                return true;
//            }
//            System.out.println("当前尚未登录");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
//                    //如果设置为true时，请求将会继续执行后面的操作
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
