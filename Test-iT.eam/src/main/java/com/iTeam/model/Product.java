package com.iTeam.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String name;
    private String description;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Positive(message = "O preço deve ser um valor positivo.")
    private BigDecimal price;

    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa.")
    private Integer quantityInStock;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public @NotBlank(message = "O nome do produto é obrigatório.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "O nome do produto é obrigatório.") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull(message = "O preço do produto é obrigatório.") @Positive(message = "O preço deve ser um valor positivo.") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "O preço do produto é obrigatório.") @Positive(message = "O preço deve ser um valor positivo.") BigDecimal price) {
        this.price = price;
    }

    public @Min(value = 0, message = "A quantidade em estoque não pode ser negativa.") Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(@Min(value = 0, message = "A quantidade em estoque não pode ser negativa.") Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
