package com.HelloUser.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/formpage")
    public String formPage(Model model) {
        model.addAttribute("newMember", new Member(null, null, 0));
        return "formpage";
    }

    @PostMapping("/new-member")
    public String newMember(@RequestParam String name, @RequestParam String email, Model model) {

        System.out.println("new member "+ "Namn: " + name + " Email: " + email);
        // create a new member object with a unique ID based on the sixe of the member list 
        Member newMember =  new Member(name, email, MemberController.members.size() + 1);
        //add the new member to member list
        MemberController.members.add(newMember);
        // skapa en ny member 

        System.out.println("Ny Medlem tillagd " + newMember);
        return "redirect:/formpage";
    }
    
}
