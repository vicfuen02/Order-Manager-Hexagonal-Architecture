package com.springbootessentials.springbootessentials.domain.common;


public class Code {

    private String code;
    private String desc;

    public Code() {
    }

    public Code(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
