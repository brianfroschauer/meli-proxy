package com.mercadolibre.proxy.interceptor;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Data
class Context {

    private static Context INSTANCE = null;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private long duration;

    private Context() {}

    static Context getInstance() {
        if (INSTANCE == null) {
            synchronized(Context.class) {
                INSTANCE = new Context();
            }
        }
        return INSTANCE;
    }
}
