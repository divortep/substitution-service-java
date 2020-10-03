package com.app.core;

import com.app.models.Input;
import com.app.models.SubstitutionType;

public interface Substitution {

    SubstitutionType getType();

    boolean complyWith(Input input);

    double apply(Input input);
}
