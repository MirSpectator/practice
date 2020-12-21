package com.eat.util;


import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version V1.0
 * @Package com.eat.comom.util
 * @ClassName RedisCatch
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/13 21:55
 * TODO   配置muybatis的二级缓存，使用redis进行二级缓存
 **/
public class RedisCache implements Cache {

    private String id;

    public RedisCache(String id){
        // log.info("当前的缓存id: [{}]",id);

        System.out.println("当前的缓存id: [{}]"+id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override //放入redis缓存
    public void putObject(Object key, Object value) {
        // log.info("放入缓存的key:[{}] 放入缓存的valus:[{}]",key,value);
        getRedisTemplate().opsForHash().put(id,key.toString(),value);
        // System.out.println( getRedisTemplate().opsForHash().values("1936328948"));
    }

    @Override//从redis缓存获取
    public Object getObject(Object key) {
        //log.info("取出的缓存的key:[{}] ",key.toString());
        // System.out.println("id------------->"+id);
        // System.out.println("key-------------------"+key);
        // System.out.println("key-------------------"+key.toString());
        // System.out.println(getRedisTemplate().opsForHash().get(id,key.toString()));
        return getRedisTemplate().opsForHash().get(id,key.toString());
    }

    @Override//删除指定缓存
    public Object removeObject(Object o) {
        return null;
    }

    @Override  //清除缓存
    public void clear() {
        //log.info("清除所有缓存信息...");
        getRedisTemplate().delete(id);
    }

    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
    }

    //封装获取redistemplate的方法
    public RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }






   /*

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private RedisTemplate redisTemplate;

    private String id;


    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }

        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        if (value != null) {
            //向redis中加入数据，有效期是2天
            redisTemplate.opsForValue().set(key.toString(), value, 2, TimeUnit.DAYS);
        }
    }

    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        try {
            if (key != null) {
                Object object = redisTemplate.opsForValue().get(key.toString());
                return object;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        try {
            if (key != null) {
                redisTemplate.delete(key.toString());
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();

        try {
            Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                redisTemplate.delete(keys);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getSize() {
        RedisTemplate redisTemplate = getRedisTemplate();
        Long size = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        }
        return redisTemplate;
    }*/
}
