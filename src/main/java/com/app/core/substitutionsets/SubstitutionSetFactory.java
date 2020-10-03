package com.app.core.substitutionsets;

import com.app.core.SubstitutionSet;
import com.app.core.substitutions.*;

public final class SubstitutionSetFactory {

    public static SubstitutionSet createBaseSubstitutionSet() {
        SubstitutionSet substitutionSet = new GenericSubstitutionSet();
        substitutionSet.add(new BaseSubstitutionM());
        substitutionSet.add(new BaseSubstitutionP());
        substitutionSet.add(new BaseSubstitutionT());
        return substitutionSet;
    }

    public static SubstitutionSet createCustomSubstitutionSet1() {
        SubstitutionSet substitutionSet = new GenericSubstitutionSet();
        substitutionSet.add(new BaseSubstitutionM());
        substitutionSet.add(new CustomSubstitutionP());
        substitutionSet.add(new BaseSubstitutionT());
        return substitutionSet;
    }

    public static SubstitutionSet createCustomSubstitutionSet2() {
        SubstitutionSet substitutionSet = new GenericSubstitutionSet();
        substitutionSet.add(new CustomSubstitutionM());
        substitutionSet.add(new BaseSubstitutionP());
        substitutionSet.add(new CustomSubstitutionT());
        return substitutionSet;
    }
}
