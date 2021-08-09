package me.ele.download.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * 自增主键
     * */
    private Long id;

    /**
     * 任务提交人
     * */
    private String user;

    /**
     * 任务状态 0: create 1: runing 2: failure 3: success
     * */
    private Integer status;

    /**
     * 任务类型  1: 订单导出
     * */
    private Integer type;

    /**
     * 任务条件
     * */
    private String condition;


    /**
     * 创建时间
     * */
    private Date createdAt;

    /**
     * 更新时间
     * */
    private Date updatedAt;
}
