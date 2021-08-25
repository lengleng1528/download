package me.ele.download.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CompExecuteOrderExportTaskDto {

    private Timestamp createdAtStart;
    private Timestamp createdAtEnd;
    private int limit;
}
