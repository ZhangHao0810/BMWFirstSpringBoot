package com.bistu.firstSpringBoot.service.impl;

import com.bistu.firstSpringBoot.dao.ProductDao;
import com.bistu.firstSpringBoot.model.Product;
import com.bistu.firstSpringBoot.service.ProductService;
import com.bistu.firstSpringBoot.utils.CommonQueryBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Super-Zhang
 * @date 2021-06-30 19:47
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> listByOrderNo(String orderNo) {
        Assert.notNull(orderNo, "orderNo is not null!");
        return productDao.listByOrderNo(orderNo);
    }

    @Override
    public List<Product> listShowProduct() {
        Product record = new Product();
        record.setState(1);
        return productDao.list(record);
    }
    @Override
    public Product findByProductId(Integer productId) {
        Assert.notNull(productId, "productId is null!");
        Product record = new Product();
        record.setProductId(Long.valueOf(productId));
        List<Product> list = productDao.list(record);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Product selectByPrimaryKey(Long id) {
        return productDao.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        //商品名称不能为空, productId要验证唯一也不能为空,这些上层也会验证
        Assert.notNull(record.getName(), "name对象不能为空");
        Assert.notNull(record.getProductId(), "productId不能为空");
        //验证productId唯一，即productId在数据库中不存在
        Product searchItem = new Product();
        searchItem.setProductId(record.getProductId());
        long count = productDao.count(searchItem);
        if (count > 0) {
            //productId不唯一
            return -1;
        }
        //创建时间和更新时间都不是由页面传入的，这块暂定开始发售时间也不是页面传入的，还有字段例如state都会事先在需求中明确
        //创建时间创建时设置，更新时间update的时候设置
        record.setCreateTime(new Date());
        record.setStartShowTime(new Date());
        record.setState(1);
        return productDao.insert(record);
    }
    @Override
    public int updateItem(Product record) {
        //更新的是按照主键进行更新的，所以主键不能为空
        Assert.notNull(record.getId(), "id不能为空");
        //因为updateByPrimaryKeySelective方法会把有的字段都更新，所以为了避免这种情况，实际项目中都是用新的对象更新
        Product updateItem = new Product();
        updateItem.setId(record.getId());
        //需求里面只更新userName,产品描述和产品展示url
        if (StringUtils.isNotEmpty(record.getName())) {
            updateItem.setName(record.getName());
        }
        if (StringUtils.isNotEmpty(record.getDesc())) {
            updateItem.setDesc(record.getDesc());
        }
        if (StringUtils.isNotEmpty(record.getImgUrl())) {
            updateItem.setImgUrl(record.getImgUrl());
        }
        //接下来是更新update时间
        updateItem.setUpdateTime(new Date());
        return productDao.updateByPrimaryKeySelective(updateItem);
    }

    @Override
    public List<Product> list4Page(Product record, CommonQueryBean query) {
        return productDao.list4Page(record,query);
    }

    @Override
    public long count(Product record) {
        return productDao.count(record);
    }

    @Override
    public List<Product> list(Product record) {
        return productDao.list(record);
    }
}