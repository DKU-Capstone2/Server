package com.capstone2.dku.user.domain;

import com.capstone2.dku.writer.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    List<Writer> findAllByType(String type);

    Optional<Writer> findByIdAndRole(Long id, String role);
}
