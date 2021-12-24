package com.msb.persistence.ekyc.repository;

import com.msb.persistence.ekyc.entity.EkycProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EkycProfileRepository extends JpaRepository<EkycProfileEntity,Long> {
}
