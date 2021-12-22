package com.msb.domain.consultancy.models;

import com.msb.domain.shared.vo.BranchCode;
import com.msb.domain.shared.vo.ConsultancyRequestTicketId;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ConsultancyRequestTicket extends AggregateRoot<ConsultancyRequestTicketId> {
  private ConsultancyRequestTicketId consultancyRequestTicketId;
  private CustomerId customerId;
  private String fullName;
  private ConsultancyChanel consultancyChanel;
  private String informationAdditional;
  private String timeReceiveConsultancy;
  private BranchCode transactionLocation;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
