package com.zodiac.controller;

import com.zodiac.dto.ZodiacRequest;
import com.zodiac.entity.Zodiac;
import com.zodiac.service.ZodiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zodiac")
public class ZodiacController {

    private final ZodiacService zodiacService;

    @Autowired
    public ZodiacController(ZodiacService zodiacService) {
        this.zodiacService = zodiacService;
    }

    //@GetMapping("/{sign}")
    //public ZodiacResponse getZodiacInfo(@PathVariable String sign) {
        //return zodiacService.getZodiacInfo(sign);
    //}

    @PostMapping("/add")
    public String addZodiac(@RequestBody ZodiacRequest request) {
        return zodiacService.addZodiac(request);
    }


    @GetMapping("/{sign}")
    public Zodiac getZodiacBySign(@PathVariable String sign) {
        // Dummy values — just for testing
        Zodiac zodiac = new Zodiac();
        zodiac.setSign(sign);
        zodiac.setElement("Fire");
        zodiac.setColor("Red");
        zodiac.setCompatibleSign("Leo");

        return zodiac;
    }

}
