package com.marketplace.repository;

import com.marketplace.models.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {


}
