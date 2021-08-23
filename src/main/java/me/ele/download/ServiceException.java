package me.ele.download;

/**
 * @author jiahuizhai.zjh
 * @create 2021-08-23 5:36 下午
 * @description
 */
public class ServiceException extends Exception {
    private String code;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        this(message);
        setCode(code);
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(message, cause);
        setCode(code);
    }

    public ServiceException(String code, Throwable cause) {
        super(cause);
        setCode(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
