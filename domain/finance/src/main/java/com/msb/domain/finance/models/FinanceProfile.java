package com.msb.domain.finance.models;

import com.msb.domain.shared.constant.EmploymentType;
import com.msb.domain.shared.constant.EvaluationCriteriaCode;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.domain.shared.vo.FinanceProfileId;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FinanceProfile extends AggregateRoot<FinanceProfileId> {
  private FinanceProfileId financeProfileId;
  private CustomerId customerId;
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
  private EvaluationCriteriaCode evaluationCriteriaCode;
  private List<DocumentReference> documentReferences;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
