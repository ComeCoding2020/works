package com.redis.demo.repository;

import com.redis.demo.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    @Cacheable("userCache")
    public User getUserById(String id) {
        simulateSlowService();
        User user = new User();
        user.setName("testUser" + id);
        user.setAge("testAge" + id);
        return user;
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
