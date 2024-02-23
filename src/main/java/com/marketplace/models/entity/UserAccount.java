package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.Name;
import com.marketplace.models.valueobjets.LastName;
import com.marketplace.models.valueobjets.Age;
import com.marketplace.models.valueobjets.Role;
import com.marketplace.models.valueobjets.Username;
import com.marketplace.models.valueobjets.Password;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Name name;
    @Embedded
    private LastName lastname;
    @Embedded
    private Age age;
    @Embedded
    private Username username;
    @Embedded
    private Password password;
//    private List<Role> roles;
    private String photo;

}
