package me.ele.download.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearch{
    /**
     * 订单号
     * */
    private Long orderId;

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


    ///




    ///

    /**
     * 订单索赔状态
     * 0:未索赔, 1:已索赔
     * */
    private Integer claimStatus;

    /**
     * 创建时间-开始
     * */
    private Date createAtStart;

    /**
     * 创建时间-结尾
     */
    private Date createAtEnd;




//    /**
//     * 订单id
//     * */
//    private Long orderId;
//
//    /**
//     * 下单时间
//     * */
//    private Date orderAddTime;
//
//    /**
//     * 订单终止时间
//     * */
//    private Date orderTerminalTime;
//


//    /**
//     * 更新时间
//     * */
//    private Date updateAt;






}
