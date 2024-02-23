package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.useraccount.Firstname;
import com.marketplace.models.valueobjets.useraccount.Lastname;
import com.marketplace.models.valueobjets.useraccount.Birthday;
import com.marketplace.models.valueobjets.useraccount.Username;
import com.marketplace.models.valueobjets.useraccount.Password;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private Firstname name;
    @Embedded
    private Lastname lastname;
    @Embedded
    private Birthday age;
    @Embedded
    private Username username;
    @Embedded
    private Password password;
//    private List<Role> roles;
    private String photo;

}
