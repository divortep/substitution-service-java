package com.app.controllers

import com.app.models.Input
import com.app.services.SubstitutionService
import groovy.json.JsonBuilder
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class SubstitutionControllerTest extends Specification {

    def controller
    def mockMvc
    def substitutionService

    def input
    String inputJson

    def setup() {
        substitutionService = Mock(SubstitutionService)

        controller = Spy(SubstitutionController)
        controller.substitutionService = substitutionService

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

        input = new Input()
        inputJson = new JsonBuilder(input).toPrettyString()
    }

    def "test baseSet endpoint"() {
        when:
        mockMvc.perform(post('/substitution/baseSet')
                .content(inputJson).contentType(MediaType.APPLICATION_JSON))

        then:
        1 * substitutionService.applyBaseSubstitutionSet(_)
    }

    def "test customSet1 endpoint"() {
        when:
        mockMvc.perform(post('/substitution/customSet1')
                .content(inputJson).contentType(MediaType.APPLICATION_JSON))

        then:
        1 * substitutionService.applyCustomSubstitutionSet1(_)
    }

    def "test customSet2 endpoint"() {
        when:
        mockMvc.perform(post('/substitution/customSet2')
                .content(inputJson).contentType(MediaType.APPLICATION_JSON))

        then:
        1 * substitutionService.applyCustomSubstitutionSet2(_)
    }

}
