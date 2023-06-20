package com.example.jewelryworkshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Selling {
    private String id;
    private Product product;
    private LocalDateTime dateOfSale;
    private Client client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Selling(Product product, LocalDateTime dateOfSale, Client client) {
        this.product = product;
        this.dateOfSale = dateOfSale;
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selling selling = (Selling) o;
        return Objects.equals(id, selling.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
