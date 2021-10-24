package com.it235.seata.order.service.impl;

import com.it235.seata.order.mapper.OrderMapper;
import com.it235.seata.order.model.Order;
import com.it235.seata.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jianjun.ren
 * @since 2021/02/16
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public boolean create(Order order) {
        log.info("创建订单开始");
        int index = orderMapper.insert(order);
        log.info("创建订单结束");
        return index > 0;
    }
}
