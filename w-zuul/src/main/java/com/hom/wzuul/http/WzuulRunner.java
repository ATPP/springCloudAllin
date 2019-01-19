package com.hom.wzuul.http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hom.wzuul.filter.WzuulFilter;
import com.hom.wzuul.filter.post.SendResponseFilter;
import com.hom.wzuul.filter.pre.RequestWrapperFilter;
import com.hom.wzuul.filter.route.RoutingFilter;

public class WzuulRunner {
    //静态写死过滤器
    private ConcurrentHashMap<String, List<WzuulFilter>> hashFiltersByType = new ConcurrentHashMap<String, List<WzuulFilter>>() {{
        put("pre", new ArrayList<WzuulFilter>() {{
            add(new RequestWrapperFilter());
        }});
        put("route", new ArrayList<WzuulFilter>() {{
            add(new RoutingFilter());
        }});
        put("post", new ArrayList<WzuulFilter>() {{
            add(new SendResponseFilter());
        }});
    }};

    public void init(HttpServletRequest req, HttpServletResponse resp) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setRequest(req);
        ctx.setResponse(resp);
    }

    public void preRoute() throws Throwable {
        runFilters("pre");
    }

    public void route() throws Throwable {
        runFilters("route");
    }

    public void postRoute() throws Throwable {
        runFilters("post");
    }

    public void runFilters(String sType) throws Throwable {
        List<WzuulFilter> list = this.hashFiltersByType.get(sType);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                WzuulFilter zuulFilter = list.get(i);
                zuulFilter.run();
            }
        }
    }
}
