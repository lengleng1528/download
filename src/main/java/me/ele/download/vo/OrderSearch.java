package me.ele.download.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearch{
    /**
     * 订单所有状态
     * 0:订单生成, 1:待配送, 2:配送中, 3:已送达, 4:已取消, 5:配送异常
     * */
    private Integer orderStatus;

    /**
     * 订单投诉状态
     * 0:未投诉, 1:已投诉
     * */
    private Integer complaintStatus;

}
