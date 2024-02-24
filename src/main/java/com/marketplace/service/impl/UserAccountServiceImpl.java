package com.marketplace.service.impl;

import com.marketplace.DTO.useraccount.UserAccountRequest;
import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.models.mapper.IUserAccountMapper;
import com.marketplace.repository.IUserAccountRepository;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.service.IUserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements IUserAccountService {
    private final IUserAccountRepository repository;

    @Override
    public Page<UserAccountResponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserAccountResponse findById(Long id) {
        return null;
    }

    @Override
    public void save(RegisterRequest request){

        var user = IUserAccountMapper.INSTANCE.toEntity(request);

       repository.save(user);

    }

    @Override
    public void update(Long id, UserAccountRequest request) {

    }

    @Override
    public void delete(Long id) {

    }

}
