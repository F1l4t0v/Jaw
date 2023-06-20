package com.example.jewelryworkshop.model;

import com.example.jewelryworkshop.model.enums.Materialu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {
    private String id;
    private String name;
    private String type;
    private List<Materialu> materials;
    private Map<Materialu, Double> weight;
    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String name, String type, List<Materialu> materials,
                   Map<Materialu, Double> weight, double price) {
        this.name = name;
        this.type = type;
        this.materials = materials;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
