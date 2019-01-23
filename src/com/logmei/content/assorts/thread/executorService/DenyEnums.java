package com.logmei.content.assorts.thread.executorService;

public enum DenyEnums {
    FULL(1,"已满，请等待"),
    DONE(2,"线程池已shutdown"),
    WORK_INTERRUPT(10,"任务被中断"),
    DESTORYED(11,"线程池已经被销毁");
    private int code;
    private String msg;

    DenyEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
