package cn.com;
import cn.com.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
/**
 * @author wx
 * @version 1.0
 * @date 2021/1/1 13:12
 */
@ServletComponentScan(basePackages = "cn.com")
@SpringBootApplication
@Slf4j
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }




}
