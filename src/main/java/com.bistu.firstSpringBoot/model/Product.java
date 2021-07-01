package com.bistu.firstSpringBoot.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class Product{


  /****/

  private Long id;


  /**商品名称**/
 @NotEmpty(message = "name 不能为空")
  private String name;


  /**商品价格**/
  private BigDecimal price;

  //预售开始时间
  private Date startShowTime;

  //图片地址
  private String imgUrl;


  /**状态 0 下架  1 上架**/

  private Integer state;


  /****/

  private Date createTime;


  /****/

  private Date updateTime;


  /**商品描述**/

  private String desc;


  /**商品唯一标识**/

  @NotNull(message = "productId不能为空")
  private Long productId;

    public String getCreateTimeString(){
        if (this.createTime == null) return "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(createTime);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Date getStartShowTime() {
    return startShowTime;
  }

  public void setStartShowTime(Date startShowTime) {
    this.startShowTime = startShowTime;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public void setId(Long id) { 
    this.id = id;
  }


  public Long getId() { 
    return this.id;
  }


  public void setName(String name) { 
    this.name = name;
  }


  public String getName() { 
    return this.name;
  }

  public void setState(Integer state) { 
    this.state = state;
  }


  public Integer getState() { 
    return this.state;
  }


  public void setCreateTime(Date createTime) { 
    this.createTime = createTime;
  }


  public Date getCreateTime() { 
    return this.createTime;
  }


  public void setUpdateTime(Date updateTime) { 
    this.updateTime = updateTime;
  }


  public Date getUpdateTime() { 
    return this.updateTime;
  }


  public void setDesc(String desc) { 
    this.desc = desc;
  }


  public String getDesc() { 
    return this.desc;
  }


  public void setProductId(Long productId) { 
    this.productId = productId;
  }


  public Long getProductId() { 
    return this.productId;
  }

}
