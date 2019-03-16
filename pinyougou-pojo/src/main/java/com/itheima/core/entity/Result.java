package com.itheima.core.entity;

import java.io.Serializable;

/**
 * 封装用户操作的结果信息
 */
public class Result implements Serializable {
    //操作成功与否
    private boolean flag;
    //操作信息
    private String message;

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
