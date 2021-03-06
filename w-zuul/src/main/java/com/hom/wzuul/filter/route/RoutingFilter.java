package com.hom.wzuul.filter.route;

import com.hom.wzuul.filter.WzuulFilter;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.hom.wzuul.http.RequestContext;


/**
 * 直接做转发请求，并且将返回值ResponseEntity放入全局threadlocal中
 */
public class RoutingFilter extends WzuulFilter {
    @Override
    public String filterType() {        // TODO Auto-generated method stub
        return "route";
    }

    @Override
    public int filterOrder() {        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        RequestEntity requestEntity = ctx.getRequestEntity();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(requestEntity, byte[].class);
        ctx.setResponseEntity(responseEntity);
    }


}
