package com.example.moviesdvdmicroservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;

    public Customer(String firstname,String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id",referencedColumnName = "userId",unique = true)
    private UserClaims userClaims;

    public Customer(Long id,String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
//
//    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinTable(
//            name = "movies_categories",
//            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id",nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieId",nullable = false)
//    )
//    private Set<Rentals> rentals = new HashSet<>();
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + this.getId() + '\'' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
    //API utility
    public void addUserClaims(UserClaims userClaims) {
        this.userClaims = userClaims;
        userClaims.setCustomer(this);
    }

}
