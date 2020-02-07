package work_0207.com.luo.redis.distributedlock.lockmsg;

/**
 * 有返回数据的回调函数
 * 
 * @author luolonglong
 *
 * @param <T>
 */
public interface ReturnCallBack<T> {
	T execute();
}
