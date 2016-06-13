package org.arquillian.example;

/**
 * Created by goja288 on 6/13/2016.
 */
public class SeatType {

    private Integer id;
    private String description;
    private Integer price;
    private Integer quantity;

    public SeatType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SeatType(String description, Integer price, Integer quantity) {
        this.id = 4;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
