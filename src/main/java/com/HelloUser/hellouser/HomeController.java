package com.HelloUser.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Handles GET requests to the root directory
    public String homePage(Model model) { // Adds attributes to be made available in teh view
        model.addAttribute("homePageName", "Medlemssida!");
        System.out.println("Homepage");
        return "homepage";
    }

}
