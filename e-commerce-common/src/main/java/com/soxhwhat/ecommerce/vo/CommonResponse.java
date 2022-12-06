package com.soxhwhat.ecommerce.vo;

import java.io.Serializable;

/**
 * <p>通用响应对象定义</p>
 * <p>{
 *     "code": "200",
 *     "data": {},
 *     "message": ""
 * }</p>
 *
 * @author Soxhwhat
 * @date 2022/12/6 11:08
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class CommonResponse<T> implements Serializable {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 泛型响应数据
     */
    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
