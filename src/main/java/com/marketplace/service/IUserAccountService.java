package com.marketplace.service;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserAccountService {

    List<UserAccountResponse> findAll();

    Page<UserAccountResponse> findAll(Pageable pageable);

    UserAccountResponse findById(Long id);

    UserAccount save(RegisterRequest request, UserAuth userAuth);


    void update(Long id, RegisterRequest request);

    void delete(Long id);
}
