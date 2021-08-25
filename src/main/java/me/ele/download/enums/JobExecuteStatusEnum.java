package me.ele.download.enums;

import java.util.Arrays;

public enum JobExecuteStatusEnum {


    UNEXECUTE(0, "未执行"),
    SUCCESS(1, "成功"),
    FAIL(2, "失败");

    private int status;
    private String desc;

    JobExecuteStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static JobExecuteStatusEnum getByStatus(final int status) {
        return Arrays.stream(values()).filter(s -> s.getStatus() == status).findAny().orElse(null);
    }
}
