package me.ele.download.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.ele.download.pojo.Task;
import me.ele.download.service.TaskService;
import me.ele.download.vo.TaskSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    //展示所有的任务
    @GetMapping("/task")
    public String list(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        //按照排序字段 倒序 排序
        //String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 3);
        List<Task> list = taskService.listAllTask();
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tasks";
    }


    //任务条件查询
    @PostMapping("/task/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, TaskSearch taskSearch, Model model){
        PageHelper.startPage(pageNum,3);
        List<Task> list = taskService.listTaskByVo(taskSearch);
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        model.addAttribute("pageInfo",pageInfo);
        //只更新表格中的数据
        return "admin/tasks::tasklist";
    }

    //下载接口
    @PostMapping("/task/download")
    public String download(){

        return "";
    }
}
