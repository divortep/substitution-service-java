package com.app.core.substitutionsets

import com.app.core.substitutions.*
import spock.lang.Specification

class SubstitutionSetFactoryTest extends Specification {

    def "test createBaseSubstitutionSet"() {
        when:
        def set = SubstitutionSetFactory.createBaseSubstitutionSet().getSubstitutions()

        then:
        def substClasses = set.collect({ it.getClass() })
        substClasses.size() == 3
        substClasses.contains(BaseSubstitutionM.class)
        substClasses.contains(BaseSubstitutionP.class)
        substClasses.contains(BaseSubstitutionT.class)
    }

    def "test createCustomSubstitutionSet1"() {
        when:
        def set = SubstitutionSetFactory.createCustomSubstitutionSet1().getSubstitutions()

        then:
        def substClasses = set.collect({ it.getClass() })
        substClasses.size() == 3
        substClasses.contains(BaseSubstitutionM.class)
        substClasses.contains(CustomSubstitutionP.class)
        substClasses.contains(BaseSubstitutionT.class)
    }

    def "test createCustomSubstitutionSet2"() {
        when:
        def set = SubstitutionSetFactory.createCustomSubstitutionSet2().getSubstitutions()

        then:
        def substClasses = set.collect({ it.getClass() })
        substClasses.size() == 3
        substClasses.contains(CustomSubstitutionM.class)
        substClasses.contains(BaseSubstitutionP.class)
        substClasses.contains(CustomSubstitutionT.class)
    }
}
