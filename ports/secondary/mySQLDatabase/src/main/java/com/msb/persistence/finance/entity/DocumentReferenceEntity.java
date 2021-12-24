package com.msb.persistence.finance.entity;

import com.msb.domain.finance.models.DocumentCode;
import com.msb.persistence.ekyc.entity.EkycProfileEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DocumentReference")
public class DocumentReferenceEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    private String idReferenceImage;
    @Enumerated(EnumType.STRING)
    private DocumentCode documentCode;

    @ManyToOne
    @JoinColumn(name = "financeProfileId" , nullable = false)
    private FinanceProfileEntity financeProfile;
}
