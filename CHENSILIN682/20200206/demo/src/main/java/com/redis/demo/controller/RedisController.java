package com.redis.demo.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Controller
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedissonClient redisson;

    @RequestMapping(value = "/setValue", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> setValue(@RequestBody Map<String, String> param) {
        if (StringUtils.isEmpty(param.get("key")))
            return Collections.emptyMap();
        boolean result = redisTemplate.opsForValue().setIfAbsent(param.get("key"), param.get("value"), 30, TimeUnit.SECONDS);
        return Collections.singletonMap("isSuccess", result);
    }

    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    @ResponseBody
    public String getValue(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @RequestMapping(value = "/distributedLock", method = RequestMethod.GET)
    @ResponseBody
    public void distributedLock() throws InterruptedException {
        RLock lock = redisson.getLock("myLock");
        // or wait for lock aquisition up to 3 seconds
        // and automatically unlock it after 10 seconds
        boolean res = lock.tryLock(3, 10, TimeUnit.SECONDS);
        if (res) {
            try {
                System.out.println("start do something");
                Thread.sleep(5000);
                System.out.println("end do something");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("lock is owned by another thread");
        }
    }

}
