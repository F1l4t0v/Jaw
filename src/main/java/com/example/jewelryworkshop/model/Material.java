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
public class Material {
    private String id;
    private String name;
    private double pricePerGram;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Material(String name, double pricePerGram) {
        this.name = name;
        this.pricePerGram = pricePerGram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
