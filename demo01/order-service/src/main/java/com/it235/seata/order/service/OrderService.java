package com.it235.seata.order.service;

import com.it235.seata.order.model.Order;

/**
 * @author jianjun.ren
 * @since 2021/02/16
 */
public interface OrderService {

    boolean create(Order order);
}
