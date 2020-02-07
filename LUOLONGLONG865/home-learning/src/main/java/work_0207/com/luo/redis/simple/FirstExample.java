package work_0207.com.luo.redis.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FirstExample {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void save(String userId, String value) {
		redisTemplate.boundListOps(userId).leftPush(value);
	}

	/**
	 * 如何使用lua脚本
	 * @param expectedValue
	 * @param newValue
	 * @return
	 */
	public boolean luaScript(String expectedValue, String newValue) {
		DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
		redisScript.setScriptSource(
				new ResourceScriptSource(new ClassPathResource("com/luo/spring/redis/simple/simplelua.lua")));
		redisScript.setResultType(Boolean.class);		
		return redisTemplate.execute(redisScript, Collections.singletonList("key"), expectedValue, newValue);
	}
}
