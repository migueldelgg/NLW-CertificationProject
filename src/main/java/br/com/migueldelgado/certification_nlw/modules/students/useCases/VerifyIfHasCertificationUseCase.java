package br.com.migueldelgado.certification_nlw.modules.students.useCases;

import br.com.migueldelgado.certification_nlw.modules.students.DTO.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service //Significa que vai ser a camada de serviço
//Camada de serviço, regras de negocios, buscar em repositório etc.
public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyHasCertificationDTO dto){
        if(dto.getEmail().equals("migueldelgado@gmail.com") && dto.getTechnology().equals("JAVA")) {
            return true;
        }
        return false;
    }
}
