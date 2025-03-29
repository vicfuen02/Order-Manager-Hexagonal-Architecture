package com.springbootessentials.springbootessentials.controller.common.dto;


public class CodeRDTO {

    private String code;
    private String desc;

    private CodeRDTO() {
    }

    private CodeRDTO(CodeRDTO.Builder builder) {
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

        public CodeRDTO.Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public String getDesc() {
            return desc;
        }

        public CodeRDTO.Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public CodeRDTO build() {
            return new CodeRDTO(this);
        }

    }
}
