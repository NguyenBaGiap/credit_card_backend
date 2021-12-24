package com.msb.persistence.ekyc.adapter;

import com.msb.domain.ekyc.EkycProfilePersistencePort;
import com.msb.domain.ekyc.models.EkycProfile;
import com.msb.domain.shared.vo.EkycProfileId;
import com.msb.supports.exceptions.BusinessException;

import java.util.Optional;

public class EkycProfileSpringJpaAdapter implements EkycProfilePersistencePort {
    @Override
    public Optional<EkycProfile> findByID(EkycProfileId ekycProfileId) {
        return Optional.empty();
    }

    @Override
    public EkycProfile save(EkycProfile obj) throws BusinessException {
        return null;
    }
}
