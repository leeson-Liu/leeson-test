
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Collections;
import java.util.List;

/**
 * @Author: bin.liu
 * @Date: 2022/5/9 10:40 上午
 * @Description:
 */
public class LuaTest {

    @Autowired
    private static RedisTemplate redisTemplate;

    @Autowired
    private static RedisScript<Long> rateLimitScript;
    public static void main(String[] args) {


        Long result = (Long) redisTemplate.execute(rateLimitScript, (List) redisTemplate.getKeySerializer(),
                (RedisSerializer<Long>) redisTemplate.getValueSerializer());
    }
    public RedisScript<Long> lua(){
        DefaultRedisScript<Long> rateLimitScript = new DefaultRedisScript<>();
        rateLimitScript.setLocation(new ClassPathResource("lua/testlua.lua"));
        rateLimitScript.setResultType(Long.class);
        return rateLimitScript;
    }
}
