package br.com.migueldelgado.certification_nlw.modules.students.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyHasCertificationDTO {

    private String email;
    private String technology;
}
