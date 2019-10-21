package com.mercadolibre.proxy.interceptor;

import com.mercadolibre.proxy.entity.Request;
import com.mercadolibre.proxy.repository.RequestRepository;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Component
public class PostFilter extends ZuulFilter {

    private final RequestRepository repository;

    @Autowired
    public PostFilter(RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final Context context = Context.getInstance();
        context.setDuration(System.currentTimeMillis() - context.getDuration());
        context.setResponse(RequestContext.getCurrentContext().getResponse());

        repository.save(new Request(
                context.getRequest().getRemoteAddr(),
                context.getRequest().getRequestURI(),
                context.getRequest().getMethod(),
                context.getResponse().getStatus(),
                context.getDuration(),
                new Date()
        ));

        return null;
    }
}
