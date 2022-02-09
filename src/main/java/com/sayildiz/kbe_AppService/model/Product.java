package com.sayildiz.kbe_AppService.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Product {
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @CsvBindByName
    @NotNull
    private UUID uuid;

    @NotNull
    @CsvBindByName
    private BigDecimal price;

    @NotNull
    @CsvBindByName
    private String name;

    @NotNull
    @CsvBindByName
    private String description;

    public Product(UUID uuid, BigDecimal price, String name, String description, String location, int amount, int deliveryTime) {
        this.uuid = uuid;
        this.price = price;
        this.name = name;
        this.description = description;
    }
    public Product() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(uuid, product.uuid) && Objects.equals(price, product.price) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, price, name, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid=" + uuid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
