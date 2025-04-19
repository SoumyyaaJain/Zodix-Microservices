package com.compatibility.controller;

import com.compatibility.service.CompatibilityService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/compatibility")
public class CompatibilityController {

    private final CompatibilityService compatibilityService;

    public CompatibilityController(CompatibilityService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    //@GetMapping("/{sign1}/{sign2}")
    //public String getCompatibility(@PathVariable String sign1, @PathVariable String sign2) {
        //return compatibilityService.checkCompatibility(sign1, sign2);
    //}

    @GetMapping("/{sign1}/{sign2}")
    public String getCompatibility(@PathVariable String sign1, @PathVariable String sign2) {
        return "Compatibility between " + sign1 + " and " + sign2 + " is: Very Strong 🔥";
    }
}