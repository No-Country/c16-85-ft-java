package com.marketplace.service.impl;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.exceptions.user.CannotPersistUserException;
import com.marketplace.exceptions.user.UserAccountNotFound;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.models.mapper.IUserAccountMapper;
import com.marketplace.models.valueobjets.address.Address;
import com.marketplace.repository.IUserAccountRepository;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import com.marketplace.service.IUserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements IUserAccountService {
    private final IUserAccountRepository repository;
    private final UserAuthRepository userAuthRepository;
    private final LocationServiceImpl locationService;


    @Override
    public Page<UserAccountResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(IUserAccountMapper.INSTANCE::toUserResponse);
    }

    @Override
    public UserAccountResponse findById(Long id) {
        Optional<UserAccount> requestedUser = repository.findById(id);

        if(requestedUser.isPresent()){
            var user = requestedUser.get();

            return UserAccountResponse.builder()
                    .username(user.getUsername())
                    .firstname(user.getFirstname().toString())
                    .lastname(user.getLastname().toString())
                    .build();

        }

        else{
            throw new UserAccountNotFound();
        }



    }

    @Override
    public UserAccount save(RegisterRequest request, UserAuth userAuth){
        var location = locationService.createMarDelPlataLocation(
                new Address(request.address()));

        var user = IUserAccountMapper.INSTANCE.toEntity(request);
        user.setUserAuth(userAuth);
        user.setUsername(userAuth.getUsername());
        user.setLocation(location);

        try{

            repository.save(user);
            userAuth.setUserAccount(user);

            return user;

        }catch(DataAccessException e){

            userAuthRepository.deleteById(userAuth.getId());

            throw new CannotPersistUserException();

        }

    }

    @Override
    public void update(Long id, RegisterRequest request) {
        var optionalUser = repository.findById(id);

        if(optionalUser.isPresent()){
            var user = IUserAccountMapper.INSTANCE.toEntity(request);
            user.setId(id);
            repository.save(user);
        }
    }

}