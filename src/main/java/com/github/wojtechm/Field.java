package com.github.wojtechm;

import java.util.Objects;

/**
 * @author Makiela Wojciech
 */
class Field<T> {

    private final T representation;

    Field(T t) {
        this.representation  = t;
    }

    T getRepresentation() {
        return representation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field<?> field = (Field<?>) o;
        return Objects.equals(representation, field.representation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(representation);
    }

    @Override
    public String toString() {
        return representation != null ? representation.toString() : "null";
    }
}
