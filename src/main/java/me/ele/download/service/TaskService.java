package me.ele.download.service;

import me.ele.download.enums.TaskStatusEnum;
import me.ele.download.pojo.Task;
import me.ele.download.vo.TaskQueryParam;
import me.ele.download.vo.TaskSearch;

import java.util.List;

public interface TaskService {

    List<Task> listAllTask();

    List<Task> listTaskByVo(TaskSearch taskSearch);

    void saveTask(Task task);

    List<Task> listTaskByParam(TaskQueryParam taskQueryParam);

    void changeTaskStatus(Task task, TaskStatusEnum taskStatusEnum);

    public void changeTaskUrl(Task task,String url);


}
