package cn.com;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/19 14:32
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Transaction multi = jedis.multi();
        multi.set("k4", "v4");
        multi.set("k5", "v5");
        System.out.println(multi.exec());
    }

}
