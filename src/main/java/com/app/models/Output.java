package com.app.models;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Output {
    private SubstitutionType h;
    private double k;

    public Output(final SubstitutionType h, final double k) {
        this.h = h;
        this.k = new BigDecimal(k).setScale(2, RoundingMode.FLOOR).doubleValue();
    }
}
