package com.maweiming.wechat.bot.model.initialization;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version BaseResponse.java, v 0.1 2018-11-01 00:01
 */
public class BaseResponse {

    @JSONField(name = "Ret")
    private Integer ret;

    @JSONField(name = "ErrMsg")
    private String errMsg;

    public BaseResponse() {
    }

    public BaseResponse(Integer ret, String errMsg) {
        this.ret = ret;
        this.errMsg = errMsg;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean verify(){
        return this.ret == 0;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
