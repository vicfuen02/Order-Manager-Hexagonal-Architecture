package com.springbootessentials.springbootessentials.repository.common.dto;

public class Code {

    private String code;
    private String desc;

    public Code() {
    }

    private Code(Builder builder) {
        this.code = builder.code;
        this.desc = builder.desc;
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


    public static class Builder {
        private String code;
        private String desc;
        public String getCode() {
            return code;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public String getDesc() {
            return desc;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Code build() {
            return new Code(this);
        }

    }


}
