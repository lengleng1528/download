package me.ele.download.mapper;

import me.ele.download.pojo.Task;
import me.ele.download.vo.TaskSearch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

public interface TaskMapper {

    List<Task> findAll();

    List<Task> findTaskByVo(TaskSearch taskSearch);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into tb_task values (#{id},#{user},#{status},#{type},#{condition},#{createdAt},#{updatedAt})")
    void addTask(Task task);

    Task queryTaskById(Long taskId);
}
