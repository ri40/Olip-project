package com.example.olip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @NotNull
    @Pattern(regexp = "Chash|Credit")
    private Float PaymentType ;
    @NotEmpty(message = "name is required")
    private String name;
    @PositiveOrZero
    @NotNull
    private Integer cardNo;
//=============================//
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    private Customer customer;
}
