package com.hom.wzuul.http;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hom.wzuul.http.RequestContext;



/**
 * 这个是网关的入口，逻辑也十分简单，分为三步
 * (1)将request,response放入threadlocal中
 * (2)执行三组过滤器
 * (3)清除threadlocal中的的环境变量
 */
@WebServlet(name = "w-zuul", urlPatterns = "/*")
public class WzuulServlet extends HttpServlet {
    private WzuulRunner wzuulRunner = new WzuulRunner();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        //将request，和response放入上下文对象中
        wzuulRunner.init(req, resp);
        try {
            //执行前置过滤
            wzuulRunner.preRoute();
            //执行过滤
            wzuulRunner.route();
            //执行后置过滤
            wzuulRunner.postRoute();
        } catch (Throwable e) {
            RequestContext.getCurrentContext().getResponse()
                    .sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        } finally {
            //清除变量
            RequestContext.getCurrentContext().unset();
        }
    }

}
