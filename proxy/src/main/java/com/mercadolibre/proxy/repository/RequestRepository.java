package com.mercadolibre.proxy.repository;

import com.mercadolibre.proxy.entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: brianfroschauer
 * Date: 18/10/2019
 */
@Repository
public interface RequestRepository extends CrudRepository<Request, String> {
}
