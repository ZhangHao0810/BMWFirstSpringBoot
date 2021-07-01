package test;

import com.bistu.firstSpringBoot.MainApplication;
import com.bistu.firstSpringBoot.dao.ProductDao;
import com.bistu.firstSpringBoot.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Super-Zhang
 * @date 2021-06-29 21:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ProductTest {
    @Autowired
    private ProductDao productDao;
    @Test
    public void testQuery() {
        Product record = new Product();
        record.setState(1);
        List<Product> list = productDao.list(record);
        System.out.println(list.size());
    }

    @Test
    public void testInsert() {
        Product product1 = new Product();
        product1.setCreateTime(new Date());
        product1.setDesc("本商品使用起来体验非常好");
        product1.setName("电吹风");
        product1.setPrice(new BigDecimal(1100));
        product1.setProductId(1000111L);
        product1.setState(1);
        productDao.insert(product1);
        //保存成功会把自增主键id返回回来
        System.out.println(product1.getId());
        Product product2 = new Product();
        product2.setCreateTime(new Date());
        product2.setDesc("本洗衣机带烘干功能");
        product2.setName("洗衣机");
        product2.setPrice(new BigDecimal(1100));
        product2.setProductId(1000222L);
        product2.setState(1);
        productDao.insert(product2);
        //保存成功会把自增主键id返回回来
        System.out.println(product2.getId());
    }
}