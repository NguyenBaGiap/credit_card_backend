package com.msb.persistence.creditCardRating.entity;

import com.msb.persistence.creditCard.entity.CreditCardEntity;
import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CreditCardRating")
public class CreditCardRatingEntity extends AbstractEntity<CardRatingKey> {

    @EmbeddedId
    private CardRatingKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    @ManyToOne
    @MapsId(value = "creditCardId")
    @JoinColumn(name = "creditCardId")
    private CreditCardEntity creditCard; // CreditCard
    private String comment;

    @Override
    public CardRatingKey getId() {
        return id;
    }
}
