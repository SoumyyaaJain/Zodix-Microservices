package controller;

import com.example.apiserver.Zodiac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import service.ZodiacClientService;

public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home-page";  // corresponds to Home.html
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

    @GetMapping("/check-compatibility")
    public String checkCompatibility(@RequestParam String sign1,
                                     @RequestParam String sign2,
                                     Model model) {
        // For now, just build a dummy message. Later, we’ll call zodiac microservice.
        String result = "Compatibility between " + sign1 + " and " + sign2 + " is fantastic!";
        model.addAttribute("compatibilityText", result);
        return "compatibility-page";
    }

    @GetMapping("/check-color-compatibility")
    public String checkColorCompatibility(@RequestParam String color1,
                                          @RequestParam String color2,
                                          Model model) {
        String result = "The color compatibility between " + color1 + " and " + color2 + " is harmonious!";
        model.addAttribute("colorCompatibilityText", result);
        return "color-compatibility-page"; // This is the HTML page name
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Controller
    public class ZodiacInfoController {

        @GetMapping("/zodiac-info/{sign}")
        public String getZodiacInfo(@PathVariable String sign, Model model) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8083/zodiac/" + sign;
            Zodiac zodiac = restTemplate.getForObject(url, Zodiac.class);

            model.addAttribute("zodiac", zodiac);
            return "zodiac-info"; // This is your Thymeleaf HTML page
        }
    }}




