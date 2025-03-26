package com.collection.collection_record.collections;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "collections")
public class Collections {

    @Id
    @Column(name = "collections_name")
    private String name ;
    @Column(name = "collections_type")
    private String type ;

    private String brand ;

    private String ip ;


    @Column(name = "collections_cost")
    private Integer cost ;

    private Integer years ;

    public Collections() {
    }

    public Collections(String type, String brand, String ip, String name, Integer cost, Integer years) {
        this.type = type;
        this.brand = brand;
        this.ip = ip;
        this.name = name;
        this.cost = cost;
        this.years = years;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
