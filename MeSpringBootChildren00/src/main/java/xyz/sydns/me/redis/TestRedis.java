package xyz.sydns.me.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 06/02/2018.
 */

public class TestRedis {
    // @Autowired
    // private RedisTemplate redisTemplate;

    @Autowired
    private static StringRedisTemplate stringRedisTemplate;


    public static String setString(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, (String) value);
        // redisTemplate.setKeySerializer();
        return null;
    }

    public static void main(String[] args) {
        TestRedis.setString("test", "test");
    }

}
