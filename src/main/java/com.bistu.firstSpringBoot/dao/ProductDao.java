package com.bistu.firstSpringBoot.dao;

import java.util.List;
import com.bistu.firstSpringBoot.model.Product;
import com.bistu.firstSpringBoot.utils.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Product数据库操作接口类
 * 
 **/

@Repository
public interface ProductDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Product  selectByPrimaryKey(@Param("id") Long id);

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey(@Param("id") Long id);

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert(Product record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective(Product record);

	/**
	 * 根据订单号查询商品列表.
	 * @param orderNo
	 * @return
	 */
	List<Product> listByOrderNo(String orderNo );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Product> list4Page(@Param("record") Product record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count(Product record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Product> list(Product record);

}