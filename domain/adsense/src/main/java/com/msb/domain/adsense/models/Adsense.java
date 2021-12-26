package com.msb.domain.adsense.models;

import com.msb.domain.shared.vo.CustomerId;
import com.msb.supports.domain.AggregateRoot;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Adsense extends AggregateRoot<AdsenseId> {
    private AdsenseId adsenseId;
    private CustomerId customerIds;
    private String utmSource;
    private String utmMedium;
    private String utmCampaign;
    private String utmContent;
    private LocalDateTime createdAt;
}
