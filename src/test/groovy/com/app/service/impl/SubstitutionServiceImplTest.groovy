package com.app.service.impl

import com.app.core.SubstitutionSet
import com.app.core.substitutionsets.GenericSubstitutionSet
import com.app.models.Input
import com.app.services.impl.SubstitutionServiceImpl
import spock.lang.Specification

class SubstitutionServiceImplTest extends Specification {
    def substService
    def baseSubstitutionSet
    def customSubstitutionSet1
    def customSubstitutionSet2

    def setup() {
        substService = new SubstitutionServiceImpl()

        baseSubstitutionSet = Mock(SubstitutionSet)
        customSubstitutionSet1 = Mock(SubstitutionSet)
        customSubstitutionSet2 = Mock(SubstitutionSet)

        substService.baseSubstitutionSet = baseSubstitutionSet
        substService.customSubstitutionSet1 = customSubstitutionSet1
        substService.customSubstitutionSet2 = customSubstitutionSet2
    }

    def "test init"() {
        when:
        substService.init()

        then:
        substService.baseSubstitutionSet instanceof GenericSubstitutionSet
        substService.customSubstitutionSet1 instanceof GenericSubstitutionSet
        substService.customSubstitutionSet2 instanceof GenericSubstitutionSet
    }

    def "test performBaseSubstitution"() {
        when:
        substService.applyBaseSubstitutionSet(new Input())

        then:
        1 * baseSubstitutionSet.apply(_)
    }

    def "test applyCustomSubstitutionSet1"() {
        when:
        substService.applyCustomSubstitutionSet1(new Input())

        then:
        1 * customSubstitutionSet1.apply(_)
    }

    def "test applyCustomSubstitutionSet2"() {
        when:
        substService.applyCustomSubstitutionSet2(new Input())

        then:
        1 * customSubstitutionSet2.apply(_)
    }

}
