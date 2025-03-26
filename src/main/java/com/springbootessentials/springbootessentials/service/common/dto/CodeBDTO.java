package com.springbootessentials.springbootessentials.service.common.dto;

import com.springbootessentials.springbootessentials.repository.common.dto.Code;

public class CodeBDTO {

    private String code;
    private String desc;

    public CodeBDTO() {
    }

    private CodeBDTO(CodeBDTO.Builder builder) {
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

        public CodeBDTO.Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public String getDesc() {
            return desc;
        }

        public CodeBDTO.Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public CodeBDTO build() {
            return new CodeBDTO(this);
        }

    }
}
