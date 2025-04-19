package service;

import com.example.apiserver.Zodiac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ZodiacClientService {

    @Autowired
    private RestTemplate restTemplate;

    public Zodiac getZodiacDetails(String sign) {
        String url = "http://localhost:8083/zodiac/" + sign; // Replace with actual port of zodiac-service
        return restTemplate.getForObject(url, Zodiac.class);
    }
}
