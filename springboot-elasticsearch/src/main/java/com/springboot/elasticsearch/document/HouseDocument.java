package com.springboot.elasticsearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.geo.Point;

import java.io.Serializable;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 10:10
 * 索引(index)等价于数据库中的表，文档(type)等价于数据库表中的行，每个文档的列(属性)
 * indexName ： 索引名称
 * type  ： 文档类型
 * shards ：分片
 * replicas ： 分片的一份或多份拷贝，即复制
 * refreshInterval ： 刷新间隔时间
 * @author: zhaojw
 */

@Document(indexName = "zhaojw_master",type = "house",shards = 1,replicas = 0, refreshInterval = "-1")
public class HouseDocument implements Serializable{
    /**
     * 房屋id
     */
    @Id
    private Long houseId;
    /**
     * 房屋名称
     */
    @Field
    private String houseName;
    /**
     * 城市名称
     */
    @Field
    private String cityName;
    /**
     * 区名称
     */
    @Field
    private String distinctName;
    /**
     * 商圈
     */
    @Field
    private String areaName;
    /**
     * 空间坐标
     */
    @Field
    private Point location;
    /**
     * 状态，1：正常。2：删除
     */
    @Field
    private Integer status;
    /**
     * 租金
     */
    @Field
    private Double price;

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistinctName() {
        return distinctName;
    }

    public void setDistinctName(String distinctName) {
        this.distinctName = distinctName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HouseDocument{" +
                "houseId=" + houseId +
                ", houseName='" + houseName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", distinctName='" + distinctName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", location=" + location +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
