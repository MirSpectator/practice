package com.money.utils.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Package com.money.utils.impl
 * @ClassName c
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 23:21
 **/
public class CacheUtil {
    private final static Map<String, Entity> map = new HashMap<>();
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public synchronized static void put(String key, Object data) throws Exception{
        CacheUtil.put(key, data, 0);
    }

    public synchronized static void put(String key, Object data, long expire) throws Exception{
        CacheUtil.remove(key);
        if (expire > 0) {
            Future future = executor.schedule(() -> {
                synchronized (CacheUtil.class) {
                    map.remove(key);
                }
            }, expire, TimeUnit.MILLISECONDS);
            map.put(key, new Entity(data, future));
        } else {
            //不设置过期时间
            map.put(key, new Entity(data, null));
        }
    }

    public synchronized static <T> T get(String key) throws Exception{
        Entity entity = map.get(key);
        return entity == null ? null : (T) entity.value;
    }

    public synchronized static <T> T remove(String key) throws Exception{
        //清除原缓存数据
        Entity entity = map.remove(key);
        if (entity == null) {
            return null;
        }
        //清除原键值对定时器
        if (entity.future != null) {
            entity.future.cancel(true);
        }
        return (T) entity.value;
    }

    public synchronized static int size() throws Exception{
        return map.size();
    }

    private static class Entity {
        public Object value;
        public Future future;

        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }
    }
}