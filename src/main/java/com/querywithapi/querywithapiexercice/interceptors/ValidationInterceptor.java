package com.querywithapi.querywithapiexercice.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("validationHeader")
public class ValidationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class);

    @Value("${app.auth.token}")
    private String token;


     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String Authorization = request.getHeader("password");

        if(Authorization == null || !Authorization.equals(token)){

            response.setContentType("application/json");
            response.setStatus(403);
            response.getWriter().write("TOKEN DE ACCESO INVALIDO O NULO");
            return false;
        }

        return true;
        
    }

    

   











  

}
