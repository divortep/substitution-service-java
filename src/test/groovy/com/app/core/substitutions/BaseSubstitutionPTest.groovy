package com.app.core.substitutions

import com.app.models.Input
import com.app.models.SubstitutionType
import spock.lang.Specification
import spock.lang.Unroll

class BaseSubstitutionPTest extends Specification {

    def "test getType"() {
        when:
        def type = new BaseSubstitutionP().getType()

        then:
        type == SubstitutionType.P
    }

    @Unroll
    def "test complyWith"() {
        given:
        def input = new Input(a: a, b: b, c: c,)

        when:
        def res = new BaseSubstitutionP().complyWith(input)

        then:
        res == exp_res

        where:
        a     | b     | c     | exp_res
        true  | true  | true  | true
        true  | false | false | false
        true  | true  | false | false
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
        def res = new BaseSubstitutionP().apply(input)

        then:
        res == exp_res

        where:
        d | e | f  | exp_res
        0 | 0 | 0  | 0
        3 | 60 | 9 | 9
    }
}
