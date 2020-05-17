package hr.fer.ris.headhunting.hh.data.repository;

import hr.fer.ris.headhunting.hh.data.entity.Experience;
import hr.fer.ris.headhunting.hh.data.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findExperienceBySkill(Skill skill);
}
