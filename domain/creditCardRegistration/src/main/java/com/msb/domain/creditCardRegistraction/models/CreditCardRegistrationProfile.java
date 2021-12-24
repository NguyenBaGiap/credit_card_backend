package com.msb.domain.creditCardRegistraction.models;

import com.msb.domain.shared.vo.*;
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
    private EkycProfileId ekycProfileId;
    private FinanceProfileId financeProfileId;
    private String nameInCard;
    private String creditLimit;
    private String cardActivationCode;
    private Boolean isReceivePhysicalCard;
    private Boolean isReceiveElectronicStatement;
    private Boolean isReceiveApprovalNotification;
    private PhysicalCreditCard physicalCreditCard;
    private BranchCode transactionLocationCode;
    private String timeReceiveConsultancy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
