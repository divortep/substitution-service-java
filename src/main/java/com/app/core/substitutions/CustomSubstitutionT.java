package com.app.core.substitutions;

import com.app.core.Substitution;
import com.app.models.Input;
import com.app.models.SubstitutionType;

public class CustomSubstitutionT implements Substitution {

    private final BaseSubstitutionT baseSubstitutionT;

    public CustomSubstitutionT() {
        this.baseSubstitutionT = new BaseSubstitutionT();
    }

    @Override
    public SubstitutionType getType() {
        return SubstitutionType.T;
    }

    @Override
    public boolean complyWith(final Input input) {
        return input.isA() && input.isB() && !input.isC();
    }

    @Override
    public double apply(final Input input) {
        return baseSubstitutionT.apply(input);
    }
}
