package com.app.core;

import com.app.models.Input;
import com.app.models.Output;

import java.util.Set;

public interface SubstitutionSet {

    void add(Substitution substitution);

    Set<Substitution> getSubstitutions();

    Output apply(Input input);
}
