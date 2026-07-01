package com.cognizant.orm_learn_2.repository;

import com.cognizant.orm_learn_2.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}