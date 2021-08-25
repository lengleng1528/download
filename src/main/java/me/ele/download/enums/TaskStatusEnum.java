package me.ele.download.enums;

import java.util.Arrays;

public enum TaskStatusEnum {

//0: create 1: runing 2: failure 3: success
    CREATE(0, "创建成功"),
    RUNNING(1, "运行中"),
    FAILURE(2, "执行失败"),
    SUCCESS(3,"执行成功");

    private int status;
    private String desc;

    TaskStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static TaskStatusEnum getByStatus(final int status) {
        return Arrays.stream(values()).filter(s -> s.getStatus() == status).findAny().orElse(null);
    }


}
