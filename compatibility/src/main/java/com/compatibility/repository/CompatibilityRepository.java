package com.compatibility.repository;

import com.compatibility.entity.Compatibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CompatibilityRepository extends JpaRepository<Compatibility, Long> {
    Optional<Compatibility> findBySign1AndSign2(String sign1, String sign2);
}
