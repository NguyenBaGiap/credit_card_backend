package com.msb.persistence.adsense.entity;

import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Adsense")
public class AdsenseEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    private String utmSource;
    private String utmMedium;
    private String utmCampaign;
    private String utmContent;
    private LocalDateTime createdAt;
}
