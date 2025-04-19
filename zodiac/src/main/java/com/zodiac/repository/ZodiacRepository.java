package com.zodiac.repository;

import com.zodiac.entity.Zodiac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ZodiacRepository extends JpaRepository<Zodiac, Long> {
    Optional<Zodiac> findBySign(String sign);
}
