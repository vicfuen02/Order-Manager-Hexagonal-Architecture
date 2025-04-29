package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="SPE_CODES", schema = "SPE_SCHEMA")
@Entity
public class CodeEntity {

    @Id
    @Column(unique = true, nullable = false, length=10)
    private String code;
    @Column(unique = true, nullable = false, length=100)
    private String desc;


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
