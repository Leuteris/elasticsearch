/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.compute.data;

import org.apache.lucene.util.BytesRef;

/**
 * Vector implementation representing a constant BytesRef value.
 */
final class ConstantBytesRefVector extends AbstractVector {

    private final BytesRef value;

    ConstantBytesRefVector(BytesRef value, int positionCount) {
        super(positionCount);
        this.value = value;
    }

    @Override
    public BytesRef getBytesRef(int position, BytesRef spare) {
        return value;
    }

    @Override
    public Object getObject(int position) {
        return value;
    }

    @Override
    public Vector filter(int... positions) {
        return new ConstantBytesRefVector(value, positions.length);
    }

    @Override
    public ElementType elementType() {
        return ElementType.BYTES_REF;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public String toString() {
        return "ConstantBytesRefVector[positions=" + getPositionCount() + "]";
    }
}
