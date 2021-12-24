package com.msb.persistence.finance.entity;

import com.msb.domain.shared.constant.EmploymentType;
import com.msb.domain.shared.constant.EvaluationCriteriaCode;
import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FinanceProfile")
public class FinanceProfileEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customerId")
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    private String jobCode;
    private String positionCode;
    private String workingTimeAtPositionCode;
    private String companyName;
    private String companyAddress;
    private String companySize;
    private String contractType;
    private String averageMonthlyIncome;
    private String formOfReceiveIncome;
    @Enumerated(EnumType.STRING)
    private EvaluationCriteriaCode evaluationCriteriaCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "financeProfile")
    private Set<DocumentReferenceEntity> documentReferences = new HashSet<>();

}
