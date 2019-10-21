package com.mercadolibre.control.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Data
@NoArgsConstructor
public class Statistic {

    @Id
    private String id;
    private long total;
    private long success;
    private long error;
    private long rateLimit;
    private long duration;
    private Date date;

    public Statistic(long total, long success, long error, long rateLimit, long duration, Date date) {
        this.total = total;
        this.success = success;
        this.error = error;
        this.rateLimit = rateLimit;
        this.duration = duration;
        this.date = date;
    }
}
