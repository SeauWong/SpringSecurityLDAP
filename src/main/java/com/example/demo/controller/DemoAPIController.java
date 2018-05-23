package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WongCU
 * @date 2018/5/21
 */
@RestController
@RequestMapping("/api/private")
public class DemoAPIController {

    @GetMapping("/demo")
    public String demo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Details:" + authentication.getDetails());
        System.out.println("credentials:" + authentication.getCredentials());
        System.out.println("principal:" + authentication.getPrincipal());
        System.out.println("name:" + authentication.getName());
        System.out.println("grantedAuthority:");
        for(GrantedAuthority grantedAuthority : authentication.getAuthorities()){
            System.out.println(grantedAuthority.getAuthority());
        }
        return "hello!";
    }
}
