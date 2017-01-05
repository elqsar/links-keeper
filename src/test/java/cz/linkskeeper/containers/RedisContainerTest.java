package cz.linkskeeper.containers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import redis.clients.jedis.Jedis;

public class RedisContainerTest {

    @ClassRule
    public static GenericContainer redis = new GenericContainer("redis:3.0.2")
            .withExposedPorts(6379);

    private Jedis jedis;

    @Before
    public void setUp() throws Exception {
        jedis = new Jedis(redis.getContainerIpAddress(), redis.getMappedPort(6379));
    }

    @Test
    public void testRetrievingStoredValue() {
        jedis.set("key", "value");

        Assert.assertEquals("the stored and retrieved values are the same",
                "value",
                jedis.get("key")
        );
    }

}
