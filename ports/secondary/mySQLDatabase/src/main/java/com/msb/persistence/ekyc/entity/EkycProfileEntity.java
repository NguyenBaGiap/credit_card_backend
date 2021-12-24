package com.msb.persistence.ekyc.entity;

import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EkycProfile")
public class EkycProfileEntity extends AbstractEntity<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customerId")
    private CustomerEntity customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ekycProfile")
    private Set<EkycOcrLivenessEntity> ekycOcrLivenessEntityList = new HashSet<>();

    @Column(name = "createdAt", columnDefinition = "timestamp")
    protected LocalDateTime createdAt;

    @Column(name = "updatedAt", columnDefinition = "timestamp")
    protected LocalDateTime updatedAt;
}
