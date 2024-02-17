package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.Name;
import com.marketplace.models.valueobjets.LastName;
import com.marketplace.models.valueobjets.Age;
import com.marketplace.models.valueobjets.Role;
import com.marketplace.models.valueobjets.Username;
import com.marketplace.models.valueobjets.Password;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Name name;
    private LastName lastName;
    private Age age;
    private Username username;
    private Password password;
    private List<Role> roles;
    private String photo;

}
