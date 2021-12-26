package com.msb.persistence.creditCardRating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class CardRatingKey implements Serializable {
    @Column(name = "studentId")
    private Long customerId;

    @Column(name = "creditCardId")
    private Long courseId;
}
