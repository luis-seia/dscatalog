package com.seiadev.dscatalog.dto;

import com.seiadev.dscatalog.entities.Product;
import com.seiadev.dscatalog.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private static final long serialVersionUID = 1L;
    private Long id;

    @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracters")
    @NotBlank(message = "Campo requerido")
    private String name;
    private String description;

    @Positive(message = "O preco deve ser positivo")
    private Double price;
    private String imgUrl;

    @PastOrPresent(message = "A data do produto nao pode ser futuro")
    private Instant date;
    private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

    public ProductDTO() {}

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.date = product.getDate();
    }

    public ProductDTO(Product entity, Set<Category> categories ) {
      this(entity);
      categories.forEach(cat ->  this.categories.add(new CategoryDTO()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
