package com.mercadolibre.control.repository;

import com.mercadolibre.control.entity.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
public interface StatisticRepository extends MongoRepository<Statistic, String> {
}
