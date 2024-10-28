package com.HelloUser.hellouser;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MemberController {

    // vi gör en arraylist av medlemmar
    private static final List<Member> members = new ArrayList<>();
    static {
        // vi lägger till medlemmar i listan
        members.add(new Member("Jonas", "jonas@hotmail.com", 0));
        members.add(new Member("Elin", "Elin@hotmail.com", 1));
        members.add(new Member("Axel", "Axel@hotmail.com", 2));
    }
    


    @GetMapping("/memberpage")
    public String memberPage(Model model) {
        // vi skickar med listan av medlemmar till vyn
        model.addAttribute("siteName", "Medlemssidan");
        model.addAttribute("members", members);

        System.out.println("Memberpage" + members);
        
        return "memberpage";
    }

}
