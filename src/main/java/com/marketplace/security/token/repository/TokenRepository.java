package com.marketplace.security.token.repository;

import com.marketplace.security.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t " +
            "INNER JOIN UserAuth u " +
            "ON t.userAuth.id = u.id " +
            "WHERE u.id = :userAuthId " +
            "AND (t.expired = false OR t.revoked = false)")
    List<Token> findALlValidTokensByUser(Long userAuthId);

    Optional<Token> findByToken(String token);
}
