package com.msb.persistence.consultancy.entity;

import com.msb.domain.consultancy.models.ConsultancyChanel;
import com.msb.domain.shared.vo.BranchCode;
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
@Table(name = "ConsultancyRequestTicket")
public class ConsultancyRequestTicketEntity extends AbstractEntity<Long> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    private String fullName;
    private String email;
    private String mobileNumber;
    private ConsultancyChanel consultancyChanel;
    private String informationAdditional;
    private String timeReceiveConsultancy;
    private String transactionLocationCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
