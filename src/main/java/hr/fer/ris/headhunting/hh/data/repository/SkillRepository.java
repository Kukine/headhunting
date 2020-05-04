package hr.fer.ris.headhunting.hh.data.repository;

import hr.fer.ris.headhunting.hh.data.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
