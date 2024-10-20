package com.example.moviesdvdmicroservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "User")
public class User  implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, unique = true, nullable = false)
    private String username;
    private String email;
    @Column(length = 500)
    private String password;


    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User() {
    }

    //    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//    private CustomerUser customer;
//    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//    private EmployeeUser employee;

    public User(Long id,String username,String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Long id,String username, Role role) {
        this.id =id;
        this.username = username;
        this.role = role;
    }

    public static User NEW_CUSTOMER(String username, String password) {
        User user = new User();
//        user.setIsActive(true);
        user.setRole(Role.CUSTOMER);
        user.setStatus(Status.APPROVED);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public static User NEW_EMPLOYEE(String username, String password) {
        User user = new User();
//        user.setIsActive(true);
        user.setRole(Role.EMPLOYEE);
        user.setStatus(Status.APPROVED);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
//        public User(Long id){
//        this.setIsActive(true);
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    //        public boolean isEnabled() {
////        return UserDetails.super.isEnabled();
//        return true;
//    }
    public boolean isEnabled() {
//        return this.getIsActive() == null || this.getIsActive();
        return true;
    }



}
