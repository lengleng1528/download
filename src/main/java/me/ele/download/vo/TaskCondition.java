package me.ele.download.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiahuizhai.zjh
 * @create 2021-08-23 11:28 上午
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCondition {

    /**
     * 订单查询条件属性
     */
    private OrderSearch orderSearch;

    /**
     * 下载中心返回属性
     */
    private DownloadCenter downloadCenter;
}
