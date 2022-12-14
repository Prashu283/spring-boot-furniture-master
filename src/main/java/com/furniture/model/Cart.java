package com.furniture.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    private int cartTotal;

    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private User user;


    @ManyToMany
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public  void clearProducts(){
        this.products.clear();
    }

    public void addProducts(Product product) {
        cartTotal=cartTotal+product.getPrize();
        products.add(product);
    }
}