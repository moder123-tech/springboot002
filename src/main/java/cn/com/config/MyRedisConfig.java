package cn.com.config;

import cn.com.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/3 20:56
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Dog> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Dog> template = new RedisTemplate<Object,Dog>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Dog> dogJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Dog>(Dog.class);
        template.setDefaultSerializer(dogJackson2JsonRedisSerializer);
        return template;
    }
}
