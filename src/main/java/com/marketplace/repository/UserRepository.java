package com.marketplace.repository;

import com.marketplace.security.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByEmail(String username);
}
