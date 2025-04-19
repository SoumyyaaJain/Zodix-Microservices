package com.compatibility.service;

import com.compatibility.entity.Compatibility;
import com.compatibility.repository.CompatibilityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompatibilityService {

    private final CompatibilityRepository compatibilityRepository;

    public CompatibilityService(CompatibilityRepository compatibilityRepository) {
        this.compatibilityRepository = compatibilityRepository;
    }

    public String checkCompatibility(String sign1, String sign2) {
        Optional<Compatibility> compatibility = compatibilityRepository.findBySign1AndSign2(sign1, sign2);

        return compatibility.map(Compatibility::getCompatibilityMessage)
                .orElse("Compatibility data not found for these signs.");
    }
}

