package com.HelloUser.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @GetMapping("/formpage") // Handles GET requests to the root directory
    public String formPage(Model model) { // Adds attributes to be made available in teh view
        // adding a new member-object to the model with the name newMember
        model.addAttribute("newMember", new Member(null, null, 0));
        return "formpage";
    }

    @PostMapping("/new-member") 
    public String newMember(@RequestParam String name, @RequestParam String email, Model model,
            RedirectAttributes redirectAttributes) {

        System.out.println("new member " + "Namn: " + name + " Email: " + email);
        // create a new member object with a unique ID based on size of member list
        Member newMember = new Member(name, email, MemberController.generateUniqueId());
        // Member newMember = new Member(name, email, MemberController.members.size() + 1);
        // add the new member to member list
        MemberController.members.add(newMember);

        redirectAttributes.addFlashAttribute("message", "Ny medlem tillagd " + name + " (" + email + ") ");

        System.out.println("Ny Medlem tillagd " + newMember);
        return "redirect:/formpage";
    }

}
