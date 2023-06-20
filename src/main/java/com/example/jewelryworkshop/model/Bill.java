package com.example.jewelryworkshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Bill {
    private String id;
    private Client client;
    private Selling selling;
    private List<Product> products;
    private Material material;
    private double discount;
    private double totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Bill(Client client, Selling selling, List<Product> products, Material material,
                double discount, double totalPrice) {
        this.client = client;
        this.selling = selling;
        this.products = products;
        this.material = material;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
