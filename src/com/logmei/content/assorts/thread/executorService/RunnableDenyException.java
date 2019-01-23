package com.logmei.content.assorts.thread.executorService;

//通知任务提交者
public class RunnableDenyException extends RuntimeException {
    private int code;

    public RunnableDenyException(DenyEnums denyEnums) {
        super(denyEnums.getMsg());
        this.code = denyEnums.getCode();
    }
}
