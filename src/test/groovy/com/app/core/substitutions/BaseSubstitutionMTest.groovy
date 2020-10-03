package com.app.core.substitutions

import com.app.models.Input
import com.app.models.SubstitutionType
import spock.lang.Specification
import spock.lang.Unroll

class BaseSubstitutionMTest extends Specification {

    def "test getType"() {
        when:
        def type = new BaseSubstitutionM().getType()

        then:
        type == SubstitutionType.M
    }

    @Unroll
    def "test complyWith"() {
        given:
        def input = new Input(a: a, b: b, c: c,)

        when:
        def res = new BaseSubstitutionM().complyWith(input)

        then:
        res == exp_res

        where:
        a     | b     | c     | exp_res
        true  | true  | true  | false
        true  | false | false | false
        true  | true  | false | true
        true  | false | true  | false
        false | false | false | false
        false | false | true  | false
        false | true  | true  | false
        false | true  | false | false
    }

    @Unroll
    def "test apply"() {
        given:
        def input = new Input(d: d, e: e, f: f,)

        when:
        def res = new BaseSubstitutionM().apply(input)

        then:
        res == exp_res

        where:
        d | e | f | exp_res
        0 | 0 | 0 | 0
        5 | 8 | 0 | 9
    }
}
