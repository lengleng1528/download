package me.ele.download.service.impl;

import me.ele.download.mapper.OrderMapper;
import me.ele.download.pojo.Order;
import me.ele.download.service.OrderService;
import me.ele.download.vo.OrderSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> listOrderByVo(OrderSearch orderSearch) {
        return orderMapper.findOrderByVo(orderSearch);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.listAll();
    }

}
