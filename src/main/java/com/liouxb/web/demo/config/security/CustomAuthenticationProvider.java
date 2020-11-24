//package com.liouxb.web.demo.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//
///**
// * @author liouwb
// */
//@Configuration
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    /**
//     * 自定义登录处理
//     *
//     * @param authentication
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String userName = (String) authentication.getPrincipal();
//        String password = (String) authentication.getCredentials();
//
////        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
////        String encodePwd = md5PasswordEncoder.encodePassword(password, userName);
//
//        UserDetails userInfo = userDetailsService.loadUserByUsername(userName);
//
//        if (!userInfo.getPassword().equals(password)) {
//            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
//        }
//
//        return new UsernamePasswordAuthenticationToken(userName, password, userInfo.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}
