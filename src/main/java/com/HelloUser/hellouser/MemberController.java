package com.HelloUser.hellouser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberController {

    // New arraylist of members
    public static final List<Member> members = new ArrayList<>();
    static {
        // Adding member to the list
        // members.add(new Member("Jonas", "jonas@hotmail.com", 0));
        // members.add(new Member("Elin", "Elin@hotmail.com", 1));
        // members.add(new Member("Axel", "Axel@hotmail.com", 2));
    }

    @GetMapping("/memberpage")
    public String memberPage(Model model) {
        // We sending a list with member to the view URL.
        model.addAttribute("members", members);
        System.out.println("Memberpage" + members);
        return "memberpage";
    }

    @GetMapping("/remove-item/{itemId}")
    String removeItem(@PathVariable Integer itemId) {
        System.out.println("remove item " + itemId);
        // Remove the member from the list if its ID matches the specified itemID
        members.removeIf(item -> item.getId() == itemId);
        return "redirect:/memberpage";
    }

}
