package com.nashtech.ecommerce.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity @Table (name = "liked_product", uniqueConstraints={@UniqueConstraint(columnNames = {"customer_id" , "product_id"})})

public @Data class LikedProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liked_product_gen")
    @SequenceGenerator(name = "liked_product_gen", sequenceName = "liked_product_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne @JoinColumn (name = "customer_id")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Customer customer;

    @ManyToOne @JoinColumn (name = "product_id")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Product product;
}
