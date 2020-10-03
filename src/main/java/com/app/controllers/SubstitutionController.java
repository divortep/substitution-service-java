package com.app.controllers;

import com.app.models.Input;
import com.app.models.Output;
import com.app.services.SubstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

    private SubstitutionService substitutionService;

    @Autowired
    public void setSubstitutionService(final SubstitutionService substitutionService) {
        this.substitutionService = substitutionService;
    }

    @PostMapping("/baseSet")
    public Output performBaseSubstitution(@RequestBody final Input input) {
        return substitutionService.applyBaseSubstitutionSet(input);
    }

    @PostMapping("/customSet1")
    public Output performCustomSubstitutionSet1(@RequestBody final Input input) {
        return substitutionService.applyCustomSubstitutionSet1(input);
    }

    @PostMapping("/customSet2")
    public Output performCustomSubstitutionSet2(@RequestBody final Input input) {
        return substitutionService.applyCustomSubstitutionSet2(input);
    }

}
