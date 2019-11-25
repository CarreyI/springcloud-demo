package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.util.Random;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        int r = new Random().nextInt(30);
        RequestContext context = RequestContext.getCurrentContext();
        context.setSendZuulResponse(r % 2 == 0);
        context.setResponseStatusCode(r % 2 == 0?200:401);
        return context;
    }
}
