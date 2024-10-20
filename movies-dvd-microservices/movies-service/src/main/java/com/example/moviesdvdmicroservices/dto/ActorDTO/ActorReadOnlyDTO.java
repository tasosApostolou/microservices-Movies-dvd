package com.example.moviesdvdmicroservices.dto.ActorDTO;

import com.example.moviesdvdmicroservices.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ActorReadOnlyDTO extends BaseDTO {
   public String firstname;
   public String lastname;

    public ActorReadOnlyDTO(Long id,String firstname, String lastname) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }


}
