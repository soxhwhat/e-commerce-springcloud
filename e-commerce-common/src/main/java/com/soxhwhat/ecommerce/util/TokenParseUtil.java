package com.soxhwhat.ecommerce.util;

import com.alibaba.fastjson.JSON;
import com.soxhwhat.ecommerce.constant.CommonConstant;
import com.soxhwhat.ecommerce.vo.LoginUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;


/**
 * <p>JWT token解析类</p>
 * <p>描述请遵循 javadoc 规范</p>
 *
 * @author Jiahui.huang@juphoon.com
 * @date 2022/12/6 0:05
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class TokenParseUtil {
    /**
     * <p>从JWT token中解析出用户信息</p>
     */
    public static LoginUserInfo parseUserInfoFromToken(String token) throws Exception {

        if (!StringUtils.hasText(token)) {
            return null;
        }

        Jws<Claims> claimsJws = parseToken(token, getPublicKey());
        Claims body = claimsJws.getBody();

        // 如果 Token 已经过期了, 返回 null
        if (body.getExpiration().before(Calendar.getInstance().getTime())) {
            return null;
        }

        return JSON.parseObject(
                body.get(CommonConstant.JWT_USER_INFO_KEY).toString(),
                LoginUserInfo.class
        );

    }

    private static Jws<Claims> parseToken(String token, PublicKey publicKey) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    private static PublicKey getPublicKey() throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(CommonConstant.PUBLIC_KEY)
        );

        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }
}

