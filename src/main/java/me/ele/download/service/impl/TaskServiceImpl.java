package me.ele.download.service.impl;

import me.ele.download.enums.TaskStatusEnum;
import me.ele.download.mapper.TaskMapper;
import me.ele.download.pojo.Task;
import me.ele.download.service.TaskService;
import me.ele.download.vo.TaskQueryParam;
import me.ele.download.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> listAllTask() {
        return taskMapper.findAll();
    }

    @Override
    public List<Task> listTaskByVo(TaskSearch taskSearch) {
        return taskMapper.findTaskByVo(taskSearch);
    }

    @Override
    public void saveTask(Task task) {
        taskMapper.addTask(task);
    }

    @Override
    public List<Task> listTaskByParam(TaskQueryParam taskQueryParam) {
        return taskMapper.queryTaskByParam(taskQueryParam);
    }

    @Override
    public void changeTaskStatus(Task task, TaskStatusEnum taskStatusEnum) {
        taskMapper.changeTaskStatus(task.getId(),taskStatusEnum.getStatus());
    }


}
