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

    @GetMapping("/memberpage") // Handles GET requests to the root directory
    public String memberPage(Model model) { // Adds attributes to be made available in teh view
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
