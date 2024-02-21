package com.marketplace.repository;

import com.marketplace.models.entity.UserAccount;
import com.marketplace.security.userauth.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAuth> findByUsername(String username);
}
