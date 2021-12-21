package com.msb.supports.domain;

import com.msb.supports.exceptions.BusinessException;

import java.util.Optional;

public interface Repository<K, T extends AggregateRoot<K>> {
  Optional<T> findByID(K key);

  T save(T obj) throws BusinessException;
}
