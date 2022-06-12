package com.example.olip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @PositiveOrZero
    @NotEmpty(message = "PhNo is required")
    private String phNo;

    @NotEmpty(message = "Password is required")
//    @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

    @NotEmpty(message = "Address is required")
    private String address;

    @PositiveOrZero
    @NotNull
    private Integer balance;
    /////////////////================////////////////

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    //@JoinColumn(name = "payment_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    private Payment payment;
//++++++++++++++++++++//
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    //@JoinColumn(name = "cart_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    private Cart cart;
    //++++++++++++++++++++//
    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinTable(
            name = "product_like",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product>likedProducts;

}
