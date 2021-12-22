package com.msb.domain.creditCardRegistraction.models;

import com.msb.domain.shared.vo.BranchCode;
import com.msb.domain.shared.vo.CreditCardRegistrationProfileId;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.domain.shared.vo.FinanceProfileId;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CreditCardRegistrationProfile extends AggregateRoot<CreditCardRegistrationProfileId> {
    private CreditCardRegistrationProfileId creditCardRegistrationProfileId;
    private CustomerId customerId;
    private FinanceProfileId financeProfileId;
    private String nameInCard;
    private String creditLimit;
    private String cardActivationCode;
    private Boolean isReceivePhysicalCard;
    private Boolean isReceiveElectronicStatement;
    private Boolean isReceiveApprovalNotification;
    private PhysicalCreditCard physicalCreditCard;
    private BranchCode transactionLocation;
    private String timeReceiveConsultancy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
