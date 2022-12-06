package com.soxhwhat.ecommerce.vo;

import lombok.Data;

/**
 * <p>授权中心鉴权之后给客户端的 Token</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Jiahui.huang@juphoon.com
 * @date 2022/12/6 11:06
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Data
public class Token {
    /**
     * JWT token
     */
    private String token;
}
