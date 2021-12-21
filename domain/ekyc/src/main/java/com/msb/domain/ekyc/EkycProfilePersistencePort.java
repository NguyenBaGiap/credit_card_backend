package com.msb.domain.ekyc;

import com.msb.domain.ekyc.models.EkycProfile;
import com.msb.domain.shared.vo.EkycProfileId;
import com.msb.supports.domain.Repository;

public interface EkycProfilePersistencePort extends Repository<EkycProfileId, EkycProfile> {
}
