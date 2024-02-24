package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.useraccount.Firstname;
import com.marketplace.models.valueobjets.useraccount.Lastname;
import com.marketplace.models.valueobjets.useraccount.Birthday;
import com.marketplace.models.valueobjets.useraccount.Username;
import com.marketplace.models.valueobjets.useraccount.Mobile;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Username username;
    @Embedded
    private Firstname firstname;
    @Embedded
    private Lastname lastname;
    @Embedded
    private Birthday birthday;
    @Embedded
    private Mobile mobile;
    @OneToOne
    private Location location;
    @OneToOne
    private UserAccount userAccount;
    @OneToOne
    @JoinColumn(name = "contractor_profile_id")
    private ContractorProfile contractorProfile;
    @OneToMany(mappedBy = "userAccount")
    private List<ServicesHistory> servicesHistory;
    private String photo;

}
