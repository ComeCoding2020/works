package work_0207.com.luo.redis.distributedlock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work_0207.com.luo.redis.distributedlock.lockmsg.LuaLockRedisLockManager;
import work_0207.com.luo.redis.distributedlock.lockmsg.SimpleCallBack;
import work_0207.com.luo.redis.distributedlock.lockmsg.SimpleRedisLockManager;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class TestCtrl {
	
	@Autowired
	private SimpleRedisLockManager simpleRedisLockManager;
	
	@Autowired
	private LuaLockRedisLockManager luaLockRedisLockManager;
	
	@ResponseBody
	@RequestMapping("/distributeLock")
	public String distributeLock(){
		
		simpleRedisLockManager.lockCallBack("distributeLock" + ThreadLocalRandom.current().nextInt(1000), new SimpleCallBack() {
			@Override
			public void execute() {
				System.out.println("lockCallBack");
			}
		});
		return "distributeLock";
	}
	
	@ResponseBody
	@RequestMapping("/distributeLock2")
	public String distributeLock2(){
		luaLockRedisLockManager.lockCallBack("distributeLock2" + ThreadLocalRandom.current().nextInt(1000), new SimpleCallBack() {
			@Override
			public void execute() {
				System.out.println("distributeLock2");
			}
		});
		return "distributeLock2";
	}
}
