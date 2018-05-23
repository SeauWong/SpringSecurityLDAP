package com.example.demo.config;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author WongCU
 * @date 2018/5/22
 */
public class CustomSecurityContext {

    /**
     * 键为URL，值为角色集合
     */
    private static final Map<String, Collection<ConfigAttribute>> METADATA_SOURCE_MAP = new HashMap<>();

    public static Map<String, Collection<ConfigAttribute>> getMetadataSource() {
        if (CollectionUtils.isEmpty(METADATA_SOURCE_MAP)) {
            synchronized (CustomSecurityContext.class) {
                loadMetadataSource();
            }
        }
        return new HashMap<>(METADATA_SOURCE_MAP);
    }


    private static void loadMetadataSource() {
        if (!CollectionUtils.isEmpty(METADATA_SOURCE_MAP)) {
            return;
        }
        try {
            METADATA_SOURCE_MAP.putAll(loadFromDB());
        } catch (Exception e) {
            throw new RuntimeException("加载MetadataSource失败", e);
        }
    }

    private static Map<String,Collection<ConfigAttribute>> loadFromDB(){
        //todo loadFromDB
        Map<String,Collection<ConfigAttribute>> urlRoleMap = new HashMap<>();
        List<ConfigAttribute> attributes = SecurityConfig.createList(new String[]{"dog","cat"});
        urlRoleMap.put("/api/private/demo",attributes);
        return urlRoleMap;
    }


}
