package br.com.migueldelgado.certification_nlw.modules.students.DTO;


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

    public static class StudentCertificationAnswerDTO {

        private String email;
        private String technology;
        private List<QuestionAnswerDTO> questionsAnswers;
    }
}
