package com.HelloUser.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//indikerar att klassen är en controller som hanterar webbförfrågningar
@Controller
public class HomeController {

    @GetMapping("/") // hanterar get-förfrågningar till rotkatalogen
    public String homePage(Model model) { // Lägger till attribut som ska göras tillgänliga i vyn
        model.addAttribute("homePageName", "Medlemssida!");
        System.out.println("Homepage");
        return "homepage";
    }

}
