package me.ele.download.framework;

import me.ele.download.enums.JobExecuteStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public abstract class AbstractTask<V>{

    private static final Logger logger = LoggerFactory.getLogger(AbstractTask.class);

    protected abstract String getTaskDescription();
    /**
     * 任务开始前的预处理
     *
     * @param param
     * @throws Exception
     */
    protected void preProcess(V param) throws Exception {
    }


    /**
     * 任务完成后的后处理
     *
     * @param param
     * @throws Exception
     */
    protected void postProcess(V param) throws Exception {
    }

    /**
     * 任务处理逻辑
     *
     * @param param
     * @throws Exception
     */
    protected abstract void handleTask(V param) throws Exception;

    /**
     * 执行任务
     *
     * @param param
     * @throws Exception
     */
    public final void run(V param) throws Exception {
        String taskName = generateTaskName();
        int executeStatus = JobExecuteStatusEnum.UNEXECUTE.getStatus();
        long start = System.currentTimeMillis();
        try {
            if (doRun(param, taskName, start)) {
                executeStatus = JobExecuteStatusEnum.SUCCESS.getStatus();
            }
        } catch (Exception e) {
            executeStatus = JobExecuteStatusEnum.FAIL.getStatus();
            throw e;
        }
    }
    /**
     * @return 生成任务的唯一名称
     */
    private String generateTaskName() {
        return getClass().getCanonicalName() + "|" + UUID.randomUUID().toString();
    }


    private boolean doRun(V param, String taskName, long start) throws Exception {
        preProcess(param);
        handleTask(param);
        return true;
    }





}