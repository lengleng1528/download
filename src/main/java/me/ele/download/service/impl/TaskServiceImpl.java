package me.ele.download.service.impl;

import com.alibaba.fastjson.JSON;
import me.ele.download.mapper.TaskMapper;
import me.ele.download.pojo.Task;
import me.ele.download.service.TaskService;
import me.ele.download.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public String getDownloadFile(Long taskId) {
        // 查询任务
        Task task = taskMapper.queryTaskById(taskId);
        if (Objects.isNull(task)) {
            throw ErrorMessageEnum.ILLEGAL_OPERATION.getServiceException();
        }
        // 解析
        JSON.parseObject(task.getCondition(), );
    }


}
