package com.marketplace.security.userauth.repository;

import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.model.valueobjects.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findByUsername(Username username);
}
