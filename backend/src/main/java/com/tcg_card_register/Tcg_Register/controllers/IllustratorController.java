package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.models.IllustratorModel;
import com.tcg_card_register.Tcg_Register.service.IllustratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/illustrators")
public class IllustratorController {
    @Autowired
    private IllustratorService illusService;

    @GetMapping("/")
    public List<IllustratorModel> getAllIllustrators() {return illusService.getAllIllustrators();}

    @GetMapping("/{id}")
    public IllustratorModel findIllustratorById(@PathVariable Long id) {return illusService.findIllustratorById(id);}

    @PostMapping("/create")
    public IllustratorModel createIllustrator(@RequestBody IllustratorModel illustrator) {return illusService.createIllustrator(illustrator);}

    @PutMapping(value = "/update", consumes = "application/json")
    public IllustratorModel updateIllustrator(@RequestBody IllustratorModel illustrator) {return illusService.updateIllustrator(illustrator);}

    @DeleteMapping("/delete/{id}")
    public IllustratorModel deleteIllustrator(@PathVariable Long id) {return illusService.deleteIllustrator(id);}


}
