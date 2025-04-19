package com.zodiac.service;

import com.zodiac.dto.ZodiacRequest;
import com.zodiac.dto.ZodiacResponse;
import com.zodiac.entity.Zodiac;
import com.zodiac.repository.ZodiacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZodiacService {

    private final ZodiacRepository zodiacRepository;

    @Autowired
    public ZodiacService(ZodiacRepository zodiacRepository) {
        this.zodiacRepository = zodiacRepository;
    }

    public ZodiacResponse getZodiacInfo(String sign) {
        Optional<Zodiac> zodiac = zodiacRepository.findBySign(sign);
        if (zodiac.isPresent()) {
            Zodiac z = zodiac.get();
            return new ZodiacResponse(z.getSign(), z.getElement(), z.getColor(), z.getCompatibleSign());
        } else {
            return null;
        }
    }

    public String addZodiac(ZodiacRequest request) {
        if (zodiacRepository.findBySign(request.getSign()).isPresent()) {
            return "Zodiac sign already exists!";
        }

        Zodiac zodiac = new Zodiac(request.getSign(), request.getElement(), request.getColor(), request.getCompatibleSign());
        zodiacRepository.save(zodiac);
        return "Zodiac sign added successfully!";
    }
}