package com.mercadolibre.proxy.interceptor;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final Context context = Context.getInstance();
        context.setRequest(RequestContext.getCurrentContext().getRequest());
        context.setDuration(System.currentTimeMillis());
        return null;
    }
}
