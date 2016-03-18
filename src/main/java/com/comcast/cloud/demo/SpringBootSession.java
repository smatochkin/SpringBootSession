package com.comcast.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.String;
import java.util.UUID;

@EnableRedisHttpSession
@SpringBootApplication
public class SpringBootSession {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSession.class, args);
    }
}

@Controller
class HelloRestController {
    @RequestMapping("/")
    @ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return uid.toString();
    }
}
