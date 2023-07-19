package com.example.marcell.webapichallenge.controller;

import com.example.marcell.webapichallenge.entity.Skill;
import com.example.marcell.webapichallenge.service.SkillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping
    @ApiOperation(value = "Get the list of all skills")
    public List<Skill> getAllSkills() {
        return skillService.getSkills();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get an individual skill by id")
    public Skill getSkill(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return skillService.getSkill(id);
    }

    @PostMapping
    @ApiOperation(value = "Create a new skill")
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.addSkill(skill);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing skill by id")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skillDetails) throws ChangeSetPersister.NotFoundException {
        return skillService.updateSkill(id, skillDetails);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a skill by id")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}
