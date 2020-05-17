package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Experience;
import hr.fer.ris.headhunting.hh.data.entity.Skill;
import hr.fer.ris.headhunting.hh.data.repository.ExperienceRepository;
import hr.fer.ris.headhunting.hh.data.repository.SkillRepository;
import hr.fer.ris.headhunting.hh.service.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;
    private SkillRepository skillRepository;

    @Override
    public List<Experience> getBySkill(String skillName) {
        List<Skill> skillByName = skillRepository.findSkillByName(skillName);
        Skill skill = skillByName.get(0);
        List<Experience> experienceBySkill = experienceRepository.findExperienceBySkill(skill);
        return experienceBySkill;
    }
}
