package me.ele.download.service.impl;

import com.alibaba.fastjson.JSON;
import me.ele.download.enums.TaskStatusEnum;
import me.ele.download.framework.AbstractTask;
import me.ele.download.model.dto.CompExecuteOrderExportTaskDto;
import me.ele.download.pojo.Task;
import me.ele.download.util.ExecutorServiceUtil;
import me.ele.download.vo.TaskQueryParam;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class ExecuteOrderExportTaskService extends AbstractTask<CompExecuteOrderExportTaskDto> {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteOrderExportTaskService.class);


    @Autowired
    private TaskServiceImpl taskService;

    /**
     * @return 任务的中文描述, 用于job监控
     */
    @Override
    protected String getTaskDescription() {
        return "执行官网订单导出任务";
    }


    @Override
    protected void preProcess(CompExecuteOrderExportTaskDto param) throws Exception {
        logger.info("开始执行官网订单导出任务, param = {}", JSON.toJSONString(param));
    }


    @Override
    protected void handleTask(CompExecuteOrderExportTaskDto param) throws Exception {
        List<Task> taskList = taskService.listTaskByParam(buildTaskQueryParam(param));
        if(CollectionUtils.isEmpty(taskList)){
            return;
        }
        taskList.forEach(task -> getExecutorService().submit(() -> executeTask(task)));


    }

    private void executeTask(Task task){
        //1.查redis，任务是否达到最大数，若是return，不是往下走

        //2.排除正在执行和类型不是订单到处的任务
        if(!task.getStatus().equals(0) || !task.getType().equals(1)){
            return;
        }
        preExport(task);

        //3. 根据task的查询条件查询、生成文件流、推送oss


        postExport(task);



    }

    private void preExport(Task task){
        taskService.changeTaskStatus(task, TaskStatusEnum.RUNNING);
        //redis+1

    }

    private void postExport(Task task){
        taskService.changeTaskStatus(task,TaskStatusEnum.FAILURE);
        //redis-1
    }

    private TaskQueryParam buildTaskQueryParam(CompExecuteOrderExportTaskDto param){
        TaskQueryParam taskQueryParam = new TaskQueryParam();
        taskQueryParam.setCreatedAtStart(param.getCreatedAtStart());
        taskQueryParam.setCreatedAtEnd(param.getCreatedAtEnd());
        return taskQueryParam;
    }

    /**
     * 获取线程池
     *
     * @return
     */
    private ExecutorService getExecutorService() {
        return ExecutorServiceUtil.ORDER_EXPORT_EXECUTOR;
    }
}
