package me.ele.download.mapper;

import me.ele.download.pojo.Task;
import me.ele.download.vo.TaskQueryParam;
import me.ele.download.vo.TaskSearch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    List<Task> findAll();

    List<Task> findTaskByVo(TaskSearch taskSearch);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into tb_task values (#{id},#{user},#{status},#{type},#{condition},#{createdAt},#{updatedAt},#{url})")
    void addTask(Task task);

    List<Task> queryTaskByParam(TaskQueryParam taskQueryParam);

    void changeTaskStatus(@Param("taskId")Long taskId,@Param("status") int status);
}
