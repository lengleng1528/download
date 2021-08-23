package me.ele.download.vo;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class TaskQueryParam {

    private Timestamp createdAtStart;
    private Timestamp createdAtEnd;
}
