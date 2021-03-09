package cn.com.controller;
import cn.com.bean.Dog;
import cn.com.bean.Person;
import cn.com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class HelloController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    RedisTemplate<Object, Dog> empRedisTemplate;

    public final Person person;
    @Autowired
    public HelloController(Person person) {
        this.person = person;
    }

    @RequestMapping(value = "/login")
    public String sayHello(User user, HttpSession session) {
        System.out.println(user);
        session.setAttribute("msg",user);
        return "redirect:/fff";
    }
    @RequestMapping(value = "/fff")
    public String fox(){
        return "fox";
    }

    @RequestMapping(value = "/a")
    public Object say() {
        System.out.println(person);
        return person;
    }
    @RequestMapping(value = "/success")
    public String success(Map<String,Object> map){
        map.put("hello","abc");
        map.put("user", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

    @RequestMapping(value = "/redis")
    public void redis(){

        stringRedisTemplate.opsForValue().append("msg","hello");
        final String msg = stringRedisTemplate.opsForValue().get("msg");
      /*  redisTemplate.opsForValue().set("abc",new Dog("xiaoming",20));
        final Object xiaoming = redisTemplate.opsForValue().get("abc");*/
        empRedisTemplate.opsForValue().set("abc",new Dog("xiaoming",20));
       /* Dog xiaoming = empRedisTemplate.opsForValue().get("abc");
        return xiaoming.toString();*/
    }

    @RequestMapping(value = "/send")
    public void sendEmail() throws InterruptedException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        for (int i=0;i<30;i++) {
            Thread.sleep(1000);
            System.out.println(i);
            simpleMailMessage.setFrom("2750933869@qq.com");
            simpleMailMessage.setSubject("爱心");
            simpleMailMessage.setText("我喜欢你");
            simpleMailMessage.setTo("1296749871@qq.com");
            javaMailSender.send(simpleMailMessage);
        }
    }
    @GetMapping(value = "/get/{id}")
    public String get(@RequestParam String name,@PathVariable("id") Integer id){
        System.out.println(name);
        System.out.println(id);
        return "get";
    }
    @PostMapping(value = "/post")
    public String post(){
        return "post";
    }
    @DeleteMapping(value = "/delete")
    public String delete(){
        return "delete";
    }
   @PutMapping(value = "/put")
    public String put(){
        return "put";
    }
}
