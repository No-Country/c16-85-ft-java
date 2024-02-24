package com.marketplace.service;

import com.marketplace.DTO.useraccount.UserAccountRequest;
import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IUserAccountService {

    Page<UserAccountResponse> findAll(Pageable pageable);
    UserAccountResponse findById(Long id);
    void save(RegisterRequest request);
    void update(Long id, UserAccountRequest request);
    void delete(Long id);
}
