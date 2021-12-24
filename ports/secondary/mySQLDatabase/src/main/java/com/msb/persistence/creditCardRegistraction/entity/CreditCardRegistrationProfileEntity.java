package com.msb.persistence.creditCardRegistraction.entity;

import com.msb.domain.creditCardRegistraction.models.PhysicalCreditCard;
import com.msb.domain.shared.vo.BranchCode;
import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.persistence.ekyc.entity.EkycProfileEntity;
import com.msb.persistence.finance.entity.FinanceProfileEntity;
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
@Table(name = "CreditCardRegistrationProfile")
public class CreditCardRegistrationProfileEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "ekycProfileId")
    private EkycProfileEntity ekycProfileId;

    @OneToOne
    @JoinColumn(name = "financeProfileId")
    private FinanceProfileEntity financeProfile;

    private String nameInCard;
    private String creditLimit;
    private String cardActivationCode;
    private Boolean isReceivePhysicalCard;
    private Boolean isReceiveElectronicStatement;
    private Boolean isReceiveApprovalNotification;
    private String transactionLocationCode;
    private String timeReceiveConsultancy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
