package com.example.marcell.webapichallenge.service;

import com.example.marcell.webapichallenge.repo.SkillRepository;
import com.example.marcell.webapichallenge.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(Long id) throws ChangeSetPersister.NotFoundException {
        return skillRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long id, Skill skill) throws ChangeSetPersister.NotFoundException {
        Skill skillEntity = skillRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        skillEntity.setId(skill.getId());
        skillEntity.setName(skill.getName());
        skillEntity.setLevel(skill.getLevel());
        skillEntity.setContacts(skill.getContacts());
        return skillRepository.save(skillEntity);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
