package com.example.olip.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @PositiveOrZero
    private Integer quantity;

    @JsonFormat(pattern ="yyyy-MM-dd")
    @NotNull(message = "")
    private Date createDate;

    @NotEmpty(message = "Status is required")
    private String status;



//+++++++++++++++++++++++++++++//
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    private Customer customer;
    //=========================
    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinTable(
            name = "add_to_cart",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product>addProducts;
}
