package me.ele.download.quartz;

import lombok.SneakyThrows;
import me.ele.download.model.dto.CompExecuteOrderExportTaskDto;
import me.ele.download.service.impl.ExecuteOrderExportTaskService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class ExecuteOrderExportJob implements Job {

    @Autowired
    private ExecuteOrderExportTaskService executeOrderExportTaskService;


    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        CompExecuteOrderExportTaskDto compExecuteOrderExportTaskDto = new CompExecuteOrderExportTaskDto();
        compExecuteOrderExportTaskDto.setCreatedAtStart(new Timestamp(System.currentTimeMillis()-5*60*1000));
        compExecuteOrderExportTaskDto.setCreatedAtEnd(new Timestamp(System.currentTimeMillis()+5*60*1000));
        executeOrderExportTaskService.run(compExecuteOrderExportTaskDto);
    }
}
