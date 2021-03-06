package com.nashtech.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity @Table (name = "liked_review", uniqueConstraints={@UniqueConstraint(columnNames = {"customer_id" , "review_id"})})

public @Data class LikedReview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liked_review_gen")
    @SequenceGenerator(name = "liked_review_gen", sequenceName = "liked_review_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne @JoinColumn (name = "customer_id")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Customer customer;

    @ManyToOne @JoinColumn (name = "review_id")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Review review;
}
