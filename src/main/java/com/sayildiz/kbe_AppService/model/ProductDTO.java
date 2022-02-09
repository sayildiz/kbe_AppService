package com.sayildiz.kbe_AppService.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProductDTO {
    @NotNull
    private UUID uuid;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String name;

    @NotNull
    private String description;


    private BigDecimal priceUSD;

    public ProductDTO(UUID uuid, BigDecimal price, String name, String description, BigDecimal priceUSD) {
        this.uuid = uuid;
        this.price = price;
        this.name = name;
        this.description = description;
        this.priceUSD = priceUSD;
    }

    public ProductDTO() {

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

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(price, that.price) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(priceUSD, that.priceUSD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, price, name, description, priceUSD);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "uuid=" + uuid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceUSD=" + priceUSD +
                '}';
    }
}
