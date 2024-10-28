package com.HelloUser.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/formpage")
    public String formPage() {
        return "formpage";
    }
    
}
