package com.marketplace.service.impl;

import com.marketplace.DTO.useraccount.UserAccountRequest;
import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.exceptions.user.CannotPersistUserException;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.models.mapper.IUserAccountMapper;
import com.marketplace.repository.IUserAccountRepository;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.service.IUserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
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
    public UserAccount save(RegisterRequest request, UserAuth userAuth){

        var user = IUserAccountMapper.INSTANCE.toEntity(request);
        user.setUserAuth(userAuth);

        try{

            repository.save(user);
            userAuth.setUserAccount(user);

            return user;

        }catch(DataAccessException e){

            throw new CannotPersistUserException();

        }

    }

    @Override
    public void update(Long id, UserAccountRequest request) {

    }

    @Override
    public void delete(Long id) {

    }

}