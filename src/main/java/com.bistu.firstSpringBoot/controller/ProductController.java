package com.bistu.firstSpringBoot.controller;

import com.bistu.firstSpringBoot.model.Product;
import com.bistu.firstSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Super-Zhang
 * @date 2021-06-30 19:48
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.listShowProduct();
    }

    @RequestMapping(value = "/queryItem", method = RequestMethod.GET)
    public Product query(Integer productId) {
        Product product = productService.findByProductId(productId);
        if (product != null) {
            return product;
        } else return new Product();
    }


    @RequestMapping(value = "/queryByOrderNo", method = RequestMethod.GET)
    public List<Product> queryByOrderNo(String orderNo) {
        List<Product> list = productService.listByOrderNo(orderNo);
        //为了避免查询不出数据导致的返回数据空白
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }
}
