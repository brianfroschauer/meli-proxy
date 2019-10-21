package com.mercadolibre.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author: brianfroschauer
 * Date: 19/10/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {

    private long total;
    private long success;
    private long error;
    private long rateLimit;
    private long duration;
    private Date date;
}
