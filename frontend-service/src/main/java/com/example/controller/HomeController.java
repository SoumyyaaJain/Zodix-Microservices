package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage() {
        return "home-page"; // filename: home.html in templates folder
    }

    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/home";
    }

    @GetMapping("/about")
    public String aboutColorsPage() {
        return "about-the-colors";
    }

    @GetMapping("/zodiac-compatibility")
    public String zodiacCompatibilityPage(
            @RequestParam(name = "sign1", required = false) String sign1,
            @RequestParam(name = "sign2", required = false) String sign2,
            Model model
    ) {
        model.addAttribute("sign1", sign1);
        model.addAttribute("sign2", sign2);

        // Here, later you can add logic to call compatibility-service
        // String compatibility = compatibilityService.getCompatibility(sign1, sign2);
        // model.addAttribute("compatibility", compatibility);

        return "zodiac-compatibility";
    }

    @GetMapping("/color-compatibility")
    public String colorCompatibilityPage() {
        return "color-compatibility";
    }

    @GetMapping("/air-element")
    public String airElementPage() {
        return "air-element";
    }

    @GetMapping("/fire-element")
    public String fireElementPage() {
        return "fire-element";
    }

    @GetMapping("/earth-element")
    public String earthElementPage() {
        return "earth-element";
    }

    @GetMapping("/water-element")
    public String waterElementPage() {
        return "water-element";
    }

    @GetMapping("/air-zodiacs")
    public String airZodiacsPage() {
        return "air-zodiac-signs";
    }

    @GetMapping("/fire-zodiacs")
    public String fireZodiacsPage() {
        return "fire-zodiac-signs";
    }

    @GetMapping("/earth-zodiacs")
    public String earthZodiacsPage() {
        return "earth-zodiac-signs";
    }

    @GetMapping("/water-zodiacs")
    public String waterZodiacsPage() {
        return "water-zodiac-signs";
    }


}
