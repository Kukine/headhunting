package hr.fer.ris.headhunting.hh.service;

import hr.fer.ris.headhunting.hh.data.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getBySkill(String skillName);
}
