package com.mercadolibre.proxy.client;

import com.mercadolibre.proxy.dto.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@FeignClient(name = "control-service", path = "/statistics")
public interface StatisticServiceClient {

    @RequestMapping(method = RequestMethod.POST)
    void create(@RequestBody StatisticDTO statisticDTO);
}
