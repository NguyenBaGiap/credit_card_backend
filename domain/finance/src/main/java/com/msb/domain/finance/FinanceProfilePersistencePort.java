package com.msb.domain.finance;

import com.msb.domain.finance.models.FinanceProfile;
import com.msb.domain.shared.vo.FinanceProfileId;
import com.msb.supports.domain.Repository;

public interface FinanceProfilePersistencePort extends Repository<FinanceProfileId, FinanceProfile> {
}
