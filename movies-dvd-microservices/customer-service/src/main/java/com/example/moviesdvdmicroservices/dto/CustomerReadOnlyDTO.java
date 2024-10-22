package com.example.moviesdvdmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerReadOnlyDTO extends BaseDTO {
    public String firstname;
    public String lastname;
//    public Long userId;
    public String email;

    public CustomerReadOnlyDTO(Long id, String firstname, String lastname,String email) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email=email;
    }
}
