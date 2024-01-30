package com.shawn.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.shawn.pojo.Result;
import com.shawn.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
Filter与Interceptor
接口规范不同：过滤器需要实现Filter接口，而拦截器需要实现HandlerInterceptor接口
拦截范围不同：过滤器Filter会拦截所有的资源，而Interceptor只会拦截Spring环境中的资源
 */
// Ctrl+O: 重写方法
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    // 目标资源方法运行前运行，返回true：放行，返回false，不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 获取请求url
        String url=request.getRequestURL().toString();
        log.info("请求的url: {}",url);

        // 2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login")){
            log.info("登录操作，放行...");
            return true;
        }

        // 3. 获取请求头中的令牌(token)
        String jwt=request.getHeader("token");

        // 4. 判断令牌是否存在，如果不存在，返回错误结果(未登录)
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            Result error= Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 5. 解析token，如果解析失败，返回错误结果(未登录)
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            log.info("解析令牌失败，返回未登录错误信息");
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        return true;
    }

    // 目标资源方法运行后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle ...");
        log.info("postHandle...");
    }

    // 视图渲染完毕后运行，最后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion ...");
        log.info("afterCompletion...");
    }
}
