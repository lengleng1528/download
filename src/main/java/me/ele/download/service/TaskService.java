package me.ele.download.service;

import me.ele.download.pojo.Task;
import me.ele.download.vo.TaskSearch;

import java.util.List;

public interface TaskService {

    List<Task> listAllTask();

    List<Task> listTaskByVo(TaskSearch taskSearch);

    void saveTask(Task task);
}
