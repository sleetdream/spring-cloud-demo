package com.example.model;

import com.example.consts.ValidatorConsts;

import javax.validation.constraints.NotBlank;

/**
 * 参数实体类
 */
public class UserInfo {
    @NotBlank(message = ValidatorConsts.NOTBLANK_ID)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
} 