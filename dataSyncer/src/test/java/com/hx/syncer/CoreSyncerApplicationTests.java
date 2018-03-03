package com.hx.syncer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreSyncerApplicationTests {

    @Test
    public void contextLoads() {
        SpelExpressionParser parser = new SpelExpressionParser();
        boolean result = parser.parseExpression("false,true").getValue(boolean.class);
        Assert.assertEquals(result, false);
    }

}
