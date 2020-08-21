package studyMall.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import studyMall.service.RedisService;

/**
 * @Description:
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-21 10:29
 **/
public class RedisServiceImpl implements RedisService {
    @Qualifier
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean expire(String key, long expire) {
        return false;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }
}
