package com.app.core.substitutionsets

import com.app.core.Substitution
import com.app.core.substitutions.BaseSubstitutionM
import com.app.core.substitutions.BaseSubstitutionT
import com.app.exceptions.IncorrectInputException
import com.app.models.Input
import com.app.models.SubstitutionType
import spock.lang.Specification

class GenericSubstitutionSetTest extends Specification {

    def "test add subst"() {
        given:
        def set = new GenericSubstitutionSet()
        def subst = Mock(Substitution)

        when:
        set.add(subst)

        then:
        set.substitutions.contains(subst)
    }

    def "test add existing subst"() {
        given:
        def set = new GenericSubstitutionSet()
        def subst = Mock(Substitution)
        set.add(subst)

        when:
        set.add(subst)

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "A substitution of such type or class has been already added."
    }

    def "test apply with 0 subst"() {
        when:
        new GenericSubstitutionSet().apply(new Input())

        then:
        def ex = thrown(IncorrectInputException)
        ex.message == "No one substitution complies with input."
    }

    def "test apply with more then one complying subst"() {
        given:
        def subst1 = Spy(BaseSubstitutionT)
        subst1.complyWith(_ as Input) >> true
        subst1.apply(_ as Input) >> 0

        def subst2 = Spy(BaseSubstitutionM)
        subst2.complyWith(_ as Input) >> true
        subst1.apply(_ as Input) >> 0

        def set = new GenericSubstitutionSet()
        set.add(subst1)
        set.add(subst2)

        when:
        set.apply(new Input())

        then:
        def ex = thrown(IncorrectInputException)
        ex.message == "More then one substitution complies with input."
    }

    def "test apply with null input"() {
        when:
        new GenericSubstitutionSet().apply(null)

        then:
        thrown(NullPointerException)
    }

    def "test apply success"() {
        given:
        def subst = Mock(Substitution)
        subst.getType() >> SubstitutionType.T
        subst.complyWith(_ as Input) >> true
        subst.apply(_ as Input) >> 3

        def set = new GenericSubstitutionSet()
        set.add(subst)
        def input = new Input(d: 1.0, e: 1, f: 1)

        when:
        def out = set.apply(input)

        then:
        out.h == SubstitutionType.T
        out.k == 3
    }
}
