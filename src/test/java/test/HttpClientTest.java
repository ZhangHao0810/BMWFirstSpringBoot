package test;

import com.bistu.firstSpringBoot.MainApplication;
import com.bistu.firstSpringBoot.utils.http.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Super-Zhang
 * @date 2021-07-01 15:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class HttpClientTest {
    @Autowired
    HttpClientUtil httpClientUtil;
    @Test
    public void test() {
        try {
            String str = httpClientUtil.doGet("http://www.baidu.com");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}