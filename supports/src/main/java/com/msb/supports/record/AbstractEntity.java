package com.msb.supports.record;

public abstract class AbstractEntity<I> implements Record<I> {
  private static final long serialVersionUID = 1L;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.getId() == null ? 0 : this.getId().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this.getId() == null || obj == null || !this.getClass().equals(obj.getClass())) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    AbstractEntity<?> other = (AbstractEntity<?>) obj;
    return this.getId().equals(other.getId());
  }
}
