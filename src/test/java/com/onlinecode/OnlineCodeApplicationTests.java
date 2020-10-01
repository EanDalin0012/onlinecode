package com.onlinecode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineCodeApplicationTests {

    @Test
    void contextLoads() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println("\n\n file:"+path);
    }

}
