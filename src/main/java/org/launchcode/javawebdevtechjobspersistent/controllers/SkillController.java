package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("title", "My Skills");
        model.addAttribute("skills",skillRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displaySkillForm(Model model){
        model.addAttribute(new Skill());
        return  "skills/add";
    }

    @PostMapping("add")
    public String displayAddSkillForm (@ModelAttribute @Valid Skill newSkill,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        } else {
            skillRepository.save(newSkill);
            model.addAttribute("skills",skillRepository.findAll());
        }

        return "redirect:../";

    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional <Skill>optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            Skill skill = (Skill) optionalSkill.get();
            model.addAttribute("skill", skill);
            model.addAttribute("jobs",skill.getJobs());
            return "skills/view";
        } else {
            return "redirect:../index";
        }
    }
}
