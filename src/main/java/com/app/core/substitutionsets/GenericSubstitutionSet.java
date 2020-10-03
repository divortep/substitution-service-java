package com.app.core.substitutionsets;

import com.app.core.Substitution;
import com.app.core.SubstitutionSet;
import com.app.exceptions.IncorrectInputException;
import com.app.models.Input;
import com.app.models.Output;
import com.app.models.SubstitutionType;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class GenericSubstitutionSet implements SubstitutionSet {

    private final Set<Substitution> substitutions;

    public GenericSubstitutionSet() {
        this.substitutions = new HashSet<>();
    }

    public Set<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public void add(@NonNull final Substitution substitution) {
        boolean substExist = this.substitutions
                .stream()
                .anyMatch(subst -> subst.getClass().equals(substitution.getClass())
                        || subst.getType().equals(substitution.getType()));

        if (substExist) {
            throw new IllegalArgumentException("A substitution of such type or class has been already added.");
        }

        substitutions.add(substitution);
    }

    @Override
    public Output apply(@NonNull final Input input) {
        Substitution substitution = substitutions
                .stream()
                .filter(subst -> subst.complyWith(input))
                .collect(collectingAndThen(toList(), this::takeOneOrThrowEx));

        SubstitutionType substType = substitution.getType();
        double substResult = substitution.apply(input);

        return new Output(substType, substResult);
    }

    private Substitution takeOneOrThrowEx(@NonNull final List<Substitution> substList) {
        if (substList.size() == 0) {
            throw new IncorrectInputException("No one substitution complies with input.");
        } else if (substList.size() > 1) {
            throw new IncorrectInputException("More then one substitution complies with input.");
        }

        return substList.get(0);
    }
}
