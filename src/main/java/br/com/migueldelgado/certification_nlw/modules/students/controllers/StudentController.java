package br.com.migueldelgado.certification_nlw.modules.students.controllers;

import br.com.migueldelgado.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;
import br.com.migueldelgado.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Preciso usar meu USECASE
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        // Email
        // Technology
        boolean result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if (result) { // result == true
            return "Usuário já fez a prova";
        }

        return "Usuário pode fazer a prova";
    }
}
