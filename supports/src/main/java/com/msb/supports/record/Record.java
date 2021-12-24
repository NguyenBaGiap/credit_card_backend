package com.msb.supports.record;

import java.io.Serializable;

public interface Record<I> extends Serializable {
    I getId();
}