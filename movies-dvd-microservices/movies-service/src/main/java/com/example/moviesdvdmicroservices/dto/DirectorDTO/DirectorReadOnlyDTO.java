package com.example.moviesdvdmicroservices.dto.DirectorDTO;

import com.example.moviesdvdmicroservices.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DirectorReadOnlyDTO extends BaseDTO {
    public String firstname;
    public String lastname;

    public DirectorReadOnlyDTO(Long id,String firstname, String lastname) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
