package com.mercadolibre.control.service;

import com.mercadolibre.control.entity.Statistic;
import com.mercadolibre.control.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository repository;

    public StatisticServiceImpl(StatisticRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Statistic> findAll() {
        return repository.findAll();
    }

    @Override
    public Statistic create(Statistic statistic) {
        return repository.save(statistic);
    }
}
