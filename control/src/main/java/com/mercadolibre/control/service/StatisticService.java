package com.mercadolibre.control.service;

import com.mercadolibre.control.entity.Statistic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Service
public interface StatisticService {

    /**
     * Find all statistics.
     *
     * @return statistics.
     */
    List<Statistic> findAll();

    /**
     * Create a new statistic.
     *
     * @param statistic to be created.
     * @return the created statistic.
     */
    Statistic create(Statistic statistic);
}
