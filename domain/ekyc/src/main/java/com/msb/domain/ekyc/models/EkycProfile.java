package com.msb.domain.ekyc.models;

import com.msb.domain.shared.vo.CustomerId;
import com.msb.domain.shared.vo.EkycFaceMatching;
import com.msb.domain.shared.vo.EkycOcr;
import com.msb.domain.shared.vo.EkycProfileId;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class EkycProfile extends AggregateRoot<EkycProfileId> {
    private EkycProfileId ekycProfileId;
    private CustomerId customerId;
    private EkycOcr ekycOcr;
    private EkycFaceMatching ekycFaceMatching;

}
