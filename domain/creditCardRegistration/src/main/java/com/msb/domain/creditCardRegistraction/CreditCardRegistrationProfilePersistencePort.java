package com.msb.domain.creditCardRegistraction;

import com.msb.domain.creditCardRegistraction.models.CreditCardRegistrationProfile;
import com.msb.domain.shared.vo.CreditCardRegistrationProfileId;
import com.msb.supports.domain.Repository;

public interface CreditCardRegistrationProfilePersistencePort
    extends Repository<CreditCardRegistrationProfileId, CreditCardRegistrationProfile> {}
