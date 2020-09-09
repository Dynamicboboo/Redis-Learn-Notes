package com.kuang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuang.pojo.User;
import com.kuang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class Redis02SpringbootApplicationTests {


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.set("name","kuangshen");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {

        // 在企业开发中，我们80%的情况下，都不会使用这个原生的方式去编写代码！
        // RedisUtils;

        // redisTemplate  操作不同的数据类型，api和我们的指令是一样的
        // opsForValue  操作字符串 类似String
        // opsForList   操作List 类似List
        // opsForSet
        // opsForHash
        // opsForZSet
        // opsForGeo
        // opsForHyperLogLog

        // 除了进本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的CRUD

        // 获取redis的连接对象
        //        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //        connection.flushDb();
        //        connection.flushAll();

        redisTemplate.opsForValue().set("mykey","关注狂神说公众号");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }

    @Test
    public void test() throws JsonProcessingException {
        // 真实的开发一般都使用json来传递对象
        User user = new User("狂神说", 3);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
