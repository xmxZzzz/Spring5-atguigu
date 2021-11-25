package com.example.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Package: com.example.spring5.config
 * @ClassName: ConfigAop
 * @Author: guoyy
 * @Description: 用于完全注解开发的配置类
 * @Date: 2021/11/26 上午1:21
 * @Version: 1.0
*/

@Configuration
@ComponentScan(basePackages = "com.example.spring5.aopanno")
@EnableAspectJAutoProxy
public class ConfigAop {
}
