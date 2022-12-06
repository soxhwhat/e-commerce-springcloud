package com.soxhwhat.ecommerce.vo;

import lombok.Data;

/**
 * <p>登录用户信息</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Jiahui.huang@juphoon.com
 * @date 2022/12/6 0:12
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Data
public class LoginUserInfo {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

}
