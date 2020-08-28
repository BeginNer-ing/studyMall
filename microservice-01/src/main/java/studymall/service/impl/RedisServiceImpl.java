package studymall.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import studymall.service.RedisService;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-21 10:29
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Qualifier
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key,delta);
    }
}
