package work_0207.com.luo.redis.distributedlock.lockmsg;

import org.springframework.stereotype.Component;
import work_0207.com.luo.redis.distributedlock.lock.LuaDistributeLock;

import javax.annotation.PostConstruct;

@Component
public class LuaLockRedisLockManager extends SimpleRedisLockManager {
	@PostConstruct
	public void init(){
		// 初始化锁
		distributeLock = new LuaDistributeLock(redisTemplate, "mylock_", 5);
	}
}
