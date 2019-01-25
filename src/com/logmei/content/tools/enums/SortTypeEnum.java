package com.logmei.content.tools.enums;

/**
 * @ Author     ：logmei.
 * @ Date       ：Created in 14:10 2019/1/18
 * @ Description：排序类型
 * @ Modified By：
 * @Version: 1.0.0
 */
public enum SortTypeEnum {
    BUBBLE(0,"冒泡排序"),
    QUICK(1,"快速排序"),
    INSERT(2,"插入排序"),
    ;
    private  int code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    SortTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }}
