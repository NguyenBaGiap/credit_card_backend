package com.msb.persistence.creditCard.entity;

import com.msb.persistence.creditCardRating.entity.CreditCardRatingEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CreditCard")
public class CreditCardEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "creditCard")
    private Set<CreditCardRatingEntity> customerRatings;
}
