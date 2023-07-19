package com.example.marcell.webapichallenge.repo;

import com.example.marcell.webapichallenge.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
