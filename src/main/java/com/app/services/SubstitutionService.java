package com.app.services;

import com.app.models.Input;
import com.app.models.Output;

public interface SubstitutionService {
    Output applyBaseSubstitutionSet(Input input);

    Output applyCustomSubstitutionSet1(Input input);

    Output applyCustomSubstitutionSet2(Input input);
}
