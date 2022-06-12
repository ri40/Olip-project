package com.example.olip.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull
    @PositiveOrZero
    private Integer price;
    @NotNull
    @PositiveOrZero
    private Integer stock;
    @NotEmpty(message = "description is required")
    private String description;
    @JsonFormat(pattern ="yyyy-MM-dd")
    @NotNull(message = "")
    private Date dateEnd;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "")
    private Date dateStart;
//=========================//
    @ManyToMany(mappedBy = "likedProducts",cascade = CascadeType.ALL)
    Set<Customer> likes;
//++++++++++++++++++++++++++++++++//
    @ManyToOne
    @JoinColumn(name="admin_id", nullable=false)
    private Admin admin;

    public Product() {

    }
}
