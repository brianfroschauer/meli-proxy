package com.mercadolibre.proxy.service;

import org.springframework.stereotype.Service;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Service
public interface StatisticService {

    /**
     * @return the total number of requests.
     */
    long getTotal();

    /**
     * @return the total number of successful requests.
     */
    long getSuccess();

    /**
     * @return the total number of failed requests.
     */
    long getError();

    /**
     * @return the total number of blocked requests due to the configured rate limit.
     */
    long getRateLimit();

    /**
     *
     * @return the average duration of requests.
     */
    long getDuration();

    /**
     * Delete all cached requests.
     */
    void reset();
}
