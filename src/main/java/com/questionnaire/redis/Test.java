//package com.questionnaire.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @Package: com.questionnaire.redis
// * @Auther: 喻湘东
// * @Email: Jyxd1997@163.com
// * @Date: 2019-03-04 10:04:01
// * @Description:
// */
//@RestController
//public class Test {
//
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @RequestMapping("/redis/set")
//    public String set(){
//        redisTemplate.opsForValue().set("vkey", "vergilyn", 5, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(10 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "thread recover: get vkey = " + redisTemplate.opsForValue().get("vkey");
//    }
//
//}
