package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Skill;
import hr.fer.ris.headhunting.hh.data.repository.SkillRepository;
import hr.fer.ris.headhunting.hh.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{

    private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> getAllSkills() {
        return this.skillRepository.findAll();
    }
}
