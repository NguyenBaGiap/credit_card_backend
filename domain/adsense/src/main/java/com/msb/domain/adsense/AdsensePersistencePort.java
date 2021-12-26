package com.msb.domain.adsense;

import com.msb.domain.adsense.models.Adsense;
import com.msb.domain.adsense.models.AdsenseId;
import com.msb.supports.domain.Repository;

public interface AdsensePersistencePort extends Repository<AdsenseId, Adsense> {
}
