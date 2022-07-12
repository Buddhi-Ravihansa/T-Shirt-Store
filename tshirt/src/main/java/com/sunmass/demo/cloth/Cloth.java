package com.sunmass.demo.cloth;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 5)
    private String item_Code;

    @Column(nullable = false, length = 10)
    private String catogary;

    @Column(nullable = false, length = 10)
    private String color;

    @Column(nullable = false, length = 10)
    private Double price;


    @Column(nullable = false, length = 5)
    private String size;

    @Column(nullable = false, length = 15)
    private String brand;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem_Code() {
        return item_Code;
    }

    public void setItem_Code(String item_Code) {
        this.item_Code = item_Code;
    }

    public String getCatogary() {
        return catogary;
    }

    public void setCatogary(String catogary) {
        this.catogary = catogary;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "id=" + id +
                ", item_Code='" + item_Code + '\'' +
                ", catogary='" + catogary + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
