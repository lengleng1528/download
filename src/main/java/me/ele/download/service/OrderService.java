package me.ele.download.service;

import me.ele.download.pojo.Order;
import me.ele.download.vo.OrderSearch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    //订单条件查询
    List<Order> listOrderByVo(OrderSearch orderSearch);


    List<Order> getAllOrders();
}
