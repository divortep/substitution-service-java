package com.app.core.substitutions;

import com.app.core.Substitution;
import com.app.models.Input;
import com.app.models.SubstitutionType;

public class CustomSubstitutionP implements Substitution {

    private final BaseSubstitutionP baseSubstitutionP;

    public CustomSubstitutionP() {
        baseSubstitutionP = new BaseSubstitutionP();
    }

    @Override
    public SubstitutionType getType() {
        return SubstitutionType.P;
    }

    @Override
    public boolean complyWith(final Input input) {
        return baseSubstitutionP.complyWith(input);
    }

    @Override
    public double apply(final Input input) {
        return 2 * input.getD() + (input.getD() * input.getE() / 100);
    }
}
