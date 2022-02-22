package com.example.freecharge.spring.repository;
//package com.example.freecharge.spring.repository;

import com.example.freecharge.spring.model.UserRC;
import com.example.freecharge.spring.model.UserRC;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRepositoryRCImpl
{
    private RedisTemplate<String, UserRC> redisTemplate;

    private HashOperations<String, String, UserRC> hashOperations;

    public UserRepositoryRCImpl(RedisTemplate<String, UserRC> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }


    public void save(UserRC user)
    {
        hashOperations.put("USER", user.getToken(), user);
        redisTemplate.expire("USER", 5, TimeUnit.MINUTES);
    }

    public Map<String, UserRC> findAll() {
        return hashOperations.entries("USER");
    }


    public UserRC findByToken(String token) {
        return hashOperations.get("USER", token);
    }


    public void update(UserRC user) {
        save(user);
    }


    public void delete(String token) {
        hashOperations.delete("USER", token);
    }


    public boolean hasKey(String key) {return redisTemplate.hasKey(key);}


}