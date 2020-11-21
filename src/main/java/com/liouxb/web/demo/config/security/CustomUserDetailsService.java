package com.liouxb.web.demo.config.security;

import com.liouxb.web.demo.domain.UserInfo;
import com.liouxb.web.demo.domain.UserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liouwb
 */
@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    static Map<String, UserInfo> users = new HashMap<>();
    static Map<String, UserRole> userRoleMap = new HashMap<>();

    /**
     * 初始化用户和角色信息
     *
     * 正常出数据库获取
     */
    static {
        UserInfo userInfo = new UserInfo("123", "134");
        UserRole userRole = new UserRole("123", "ADMIN");

        UserInfo userInfo1 = new UserInfo("admin", "admin");
        UserRole userRole1 = new UserRole("admin", "ADMIN");

        UserInfo userInfo2 = new UserInfo("456", "456");
        UserRole userRole2 = new UserRole("456", "DB");


        users.put(userInfo.getUserName(), userInfo);
        users.put(userInfo1.getUserName(), userInfo1);
        users.put(userInfo2.getUserName(), userInfo2);

        userRoleMap.put(userRole.getId(), userRole);
        userRoleMap.put(userRole1.getId(), userRole1);
        userRoleMap.put(userRole2.getId(), userRole2);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // 查询验证用户
        UserInfo userInfo = users.get(userName);

        // 获取用户角色权限
        UserRole userRole = userRoleMap.get(userName);

        // 添加权限集
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole.getName()));

        // 返回UserDetails实现类
        return new User(userName, userInfo.getPwd(), authorities);
    }
}
