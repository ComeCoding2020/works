package work_0207.com.luo.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching // 启动缓存
public class CacheApplication {
	private static final Logger log = LoggerFactory.getLogger(CacheApplication.class);
    
	public static void main(String[] args) {
		log.info("Start CacheApplication.. ");
		SpringApplication.run(CacheApplication.class, args);
		
	}
 

}
