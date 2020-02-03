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
    private Skill newSkill;
    private Errors errors;
    private Model model;

    @GetMapping("add")
    public String displaySkillForm(Model model){
        model.addAttribute(new Skill());
        return  "skill/add";
    }

    @PostMapping("add")
    public String displayAddSkillForm (@ModelAttribute@Valid Skill newSkill,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skill/add";
        }

        return "redirect:";

    }

    @GetMapping("view/{skillId}")
    public String displayViewEmployer(Model model, @PathVariable int skillId) {

        Optional <Skill>optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            Skill skill = (Skill) optionalSkill.get();
            model.addAttribute("skill", skillRepository.findAll());
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}


/*@Controller
@RequestMapping("employers")
public class EmployerController {


    private EmployerRepository employerRepository;

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional <Employer>optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employerRepository.findAll());
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}*/
