package work_0207.com.luo.redis.distributedlock.lock;

/**
 * 定义锁
 * @author luolonglong
 *
 */
public interface ILock {
	/**
	 * 获取锁
	 * @param lock 锁名称
	 */
	void lock(String lock);
	
	/**
	 * 释放锁
	 * @param lock 锁名称
	 */
	void unlock(String lock);
}
