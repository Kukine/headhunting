package hr.fer.ris.headhunting.hh.controller;

import hr.fer.ris.headhunting.hh.data.entity.Skill;
import hr.fer.ris.headhunting.hh.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping("")
    public List<Skill> getAllSkills(){
        return this.skillService.getAllSkills();
    }
}
