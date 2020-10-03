package com.app.services.impl;

import com.app.core.SubstitutionSet;
import com.app.core.substitutionsets.SubstitutionSetFactory;
import com.app.models.Input;
import com.app.models.Output;
import com.app.services.SubstitutionService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SubstitutionServiceImpl implements SubstitutionService {

    protected SubstitutionSet baseSubstitutionSet;
    protected SubstitutionSet customSubstitutionSet1;
    protected SubstitutionSet customSubstitutionSet2;

    @PostConstruct
    public void init() {
        baseSubstitutionSet = SubstitutionSetFactory.createBaseSubstitutionSet();
        customSubstitutionSet1 = SubstitutionSetFactory.createCustomSubstitutionSet1();
        customSubstitutionSet2 = SubstitutionSetFactory.createCustomSubstitutionSet2();
    }

    @Override
    public Output applyBaseSubstitutionSet(@NonNull final Input input) {
        return baseSubstitutionSet.apply(input);
    }

    @Override
    public Output applyCustomSubstitutionSet1(@NonNull final Input input) {
        return customSubstitutionSet1.apply(input);
    }

    @Override
    public Output applyCustomSubstitutionSet2(@NonNull final Input input) {
        return customSubstitutionSet2.apply(input);
    }
}
