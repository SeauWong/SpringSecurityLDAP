package com.example.demo.config;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.*;
/**
 * 该类负责从数据库加载权限信息
 *
 * @author WongCU
 * @date 2018/5/22
 */
@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
        //todo 1. 约束
        //todo 2. 角色
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("dog"));
        return grantedAuthorities;
    }
}
