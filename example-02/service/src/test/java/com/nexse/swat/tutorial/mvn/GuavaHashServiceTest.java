package com.nexse.swat.tutorial.mvn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuavaHashServiceTest {

    HashService service = new GuavaHashService();

    @Test
    public void testMd5() throws Exception {
        assertEquals("cippalippa", "033b2efef1cbc0512b657c6ca4854ebc",
                service.md5("cippalippa"));
        assertEquals("horoscope", "30efb17ba008d0c13258bd0a6ef75a68",
                service.md5("horoscope"));
        assertEquals("empty-string", "d41d8cd98f00b204e9800998ecf8427e",
                service.md5(""));
    }

}
