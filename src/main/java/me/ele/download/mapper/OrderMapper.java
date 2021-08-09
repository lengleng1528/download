package me.ele.download.mapper;

import me.ele.download.pojo.Order;
import me.ele.download.vo.OrderSearch;

import java.util.List;

public interface OrderMapper {

    List<Order> findOrderByVo(OrderSearch orderSearch);

    List<Order> listAll();
}
