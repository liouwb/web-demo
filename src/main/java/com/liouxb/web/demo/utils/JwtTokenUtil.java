package com.liouxb.web.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.liouxb.web.demo.entity.req.LoginReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * @author liouwb
 */
@Slf4j
@Component
public class JwtTokenUtil {

    public String createJwtToken(LoginReq req) {
        String token = "";
        token = JWT.create()
                // 设置过期时间
//                .withExpiresAt()
                .withAudience(req.getUsername())
                // 签名算法
                .sign(Algorithm.HMAC256(req.getPassword()));

        return token;
    }

    /**
     * @param accessToken
     */
    public void validAccessToken(String accessToken) {
        String userName = JWT.decode(accessToken).getAudience().get(0);

        System.out.println("username:" + userName);

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("asdhfkhasd")).build();
        DecodedJWT dJwt = jwtVerifier.verify(accessToken);

        System.out.println("-----------------");
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameByToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * 从accessToken中获取clientId
     *
     * @param accessToken
     * @return
     */
    public String getUserNameByToken(String accessToken) {
        return JWT.decode(accessToken).getAudience().get(0);
    }
//    public static void main(String[] args) {
//        AccessTokenReq req = new AccessTokenReq();
//        req.setClientId("123");
//        req.setClientSecret("asdhfkhasd");
//
////        System.out.println(createAccessToken(req));
//
//        validAccessToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMjMifQ.QLJbzX3jh38cHSz0ib88jgFEj3fB1yuc7IdwW-jtxG4");
//    }

    /**
     * 判断token是否过期
     *
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {

        return true;
    }


}
