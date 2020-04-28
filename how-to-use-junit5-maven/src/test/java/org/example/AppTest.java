package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/*
<plugin>
<artifactId>maven-surefire-plugin</artifactId>
<version>2.22.1</version>
<configuration>
<excludedGroups>stress</excludedGroups>
</configuration>
</plugin>

 */
public class AppTest {
    @Test
    @Tag("functional")
    public void test1() {
        System.err.println("test #1");
    }

    @Test
    @Tag("performance")
    public void test2() {
        System.err.println("test #2");
    }

    @Test
    @Tag("stress")
    public void test3() {
        System.err.println("test #3");
    }
}
