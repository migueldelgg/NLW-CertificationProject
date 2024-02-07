package br.com.migueldelgado.certification_nlw.modules.students.useCases;

import br.com.migueldelgado.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;
import br.com.migueldelgado.certification_nlw.modules.students.repositories.CertificationStudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Significa que vai ser a camada de serviço
//Camada de serviço, regras de negocios, buscar em repositório etc.
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyHasCertificationDTO dto){
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());

        if(!result.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
