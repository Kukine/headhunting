package hr.fer.ris.headhunting.hh.data.repository;

import hr.fer.ris.headhunting.hh.data.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findSkillByName(String name);
}
