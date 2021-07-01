package com.bistu.firstSpringBoot.service;

import com.bistu.firstSpringBoot.model.Product;
import com.bistu.firstSpringBoot.utils.CommonQueryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Super-Zhang
 * @date 2021-06-30 19:46
 */

public interface ProductService {

    /**
     * 查询全部的商品信息.
     */
    List<Product> listShowProduct();
    /**
     * 根据productId查询商品信息.
     */
    Product findByProductId(Integer productId);

    List<Product> listByOrderNo(String orderNo );
    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    Product  selectByPrimaryKey ( @Param("id") Long id );
    /**
     *
     * 删除（根据主键ID删除）
     *
     **/
    int deleteByPrimaryKey ( @Param("id") Long id );
    /**
     *
     * 添加
     *
     **/
    int insert( Product record );
    /**
     *
     * 修改 部分字段，所以更名，原先方法是有的字段全部更新，可能导致出问题.
     *
     **/
    int updateItem( Product record );
    /**
     *
     * list分页查询
     *
     **/
    List<Product> list4Page ( Product record, @Param("commonQueryParam") CommonQueryBean query);
    /**
     *
     * count查询
     *
     **/
    long count ( Product record);
    /**
     *
     * list查询
     *
     **/
    List<Product> list ( Product record);
}