package com.msb.domain.ekyc.models;

import com.msb.domain.shared.vo.*;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class EkycProfile extends AggregateRoot<EkycProfileId> {
    private EkycProfileId ekycProfileId;
    private CustomerId customerId;
    private EkycOcr ekycOcr;
    private EkycFaceMatching ekycFaceMatching;
    private EkycFaceVideo ekycFaceVideo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
