package com.marketplace.service;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IUserAccountService {

    Page<UserAccountResponse> findAll(Pageable pageable);

    UserAccountResponse findById(Long id);

    UserAccount save(RegisterRequest request, UserAuth userAuth);


    void update(Long id, RegisterRequest request);

    void delete(Long id);
}
