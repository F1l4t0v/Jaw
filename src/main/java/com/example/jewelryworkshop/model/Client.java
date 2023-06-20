package com.example.jewelryworkshop.model;

import com.example.jewelryworkshop.model.enums.Regular;
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
public class Client {
    private String id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Regular clientStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Client(String lastName, String firstName, String patronymic, Regular clientStatus) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.clientStatus = clientStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
