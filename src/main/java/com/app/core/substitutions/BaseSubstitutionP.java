package com.app.core.substitutions;

import com.app.core.Substitution;
import com.app.models.Input;
import com.app.models.SubstitutionType;

public class BaseSubstitutionP implements Substitution {
    @Override
    public SubstitutionType getType() {
        return SubstitutionType.P;
    }

    @Override
    public boolean complyWith(final Input input) {
        return input.isA() && input.isB() && input.isC();
    }

    @Override
    public double apply(final Input input) {
        return input.getD() + (input.getD() * (input.getE() - input.getF()) / 25.5);
    }
}
