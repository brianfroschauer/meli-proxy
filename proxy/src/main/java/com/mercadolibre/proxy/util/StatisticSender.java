package com.mercadolibre.proxy.util;

import com.mercadolibre.proxy.client.StatisticServiceClient;
import com.mercadolibre.proxy.dto.StatisticDTO;
import com.mercadolibre.proxy.service.StatisticService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    private final StatisticServiceClient statisticClient;
    private final StatisticService statisticService;

    public StatisticSender(StatisticServiceClient statisticClient,
                           StatisticService statisticService) {
        this.statisticClient = statisticClient;
        this.statisticService = statisticService;
    }

    @Scheduled(fixedDelay = 3600000)
    public void sendDailyStatistics() {
        final StatisticDTO statistic = new StatisticDTO(
                statisticService.getTotal(),
                statisticService.getSuccess(),
                statisticService.getError(),
                statisticService.getRateLimit(),
                statisticService.getDuration(),
                new Date()
        );
        statisticClient.create(statistic);
        statisticService.reset();
    }
}
