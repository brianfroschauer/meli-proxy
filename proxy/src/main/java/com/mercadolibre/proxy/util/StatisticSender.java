package com.mercadolibre.proxy.util;

import com.mercadolibre.proxy.dto.StatisticDTO;
import com.mercadolibre.proxy.service.StatisticService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Component
@EnableAsync
@Configuration
@EnableScheduling
public class StatisticSender {

    private final StatisticService statisticService;
    private final RestTemplate restTemplate;

    public StatisticSender(StatisticService statisticService) {
        this.statisticService = statisticService;
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedDelay = 1800000)
    public void sendDailyStatistics() {
        final StatisticDTO statistic = new StatisticDTO(
                statisticService.getTotal(),
                statisticService.getSuccess(),
                statisticService.getError(),
                statisticService.getRateLimit(),
                statisticService.getDuration(),
                new Date()
        );
        restTemplate.postForEntity("http://control-service:8081/statistics", statistic, StatisticDTO.class);
        statisticService.reset();
    }
}
