package com.msb.supports.domain;

import java.io.Serializable;

public abstract class Entity<I> implements Serializable {
  protected abstract I getIdentifier();
}
