package com.msb.persistence.ekyc.entity;

import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    private CustomerEntity customer;

    private String idFrontImage;
    private String idBackImage;
    private String idFaceImage;
    private String idFaceUpImage;
    private String idFaceLeftImage;
    private String idFaceRightImage;
    private String idFaceVideo;
    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;
}
