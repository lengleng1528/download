package me.ele.download.service.impl;

import me.ele.download.ServiceException;
import me.ele.download.mapper.TaskMapper;
import me.ele.download.pojo.Task;
import me.ele.download.service.TaskService;
import me.ele.download.service.ToolCenterService;
import me.ele.download.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ToolCenterService toolCenterService;

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
    public String getDownloadFile(String fileName) throws ServiceException {
        // 获取fileUrl
        String filePath;
        filePath = toolCenterService.getFilePath(fileName);
        if (StringUtils.isEmpty(filePath)) {
            throw new ServiceException("下载文件失败,文件名:" + fileName);
        }
        return filePath;
    }
}
