package br.com.migueldelgado.certification_nlw.modules.students.useCases;

import br.com.migueldelgado.certification_nlw.modules.questions.entities.QuestionEntity;
import br.com.migueldelgado.certification_nlw.modules.questions.repositories.QuestionRepository;
import br.com.migueldelgado.certification_nlw.modules.students.DTO.StudentCertificationAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCertificationAnswersUseCase {
    @Autowired
    private QuestionRepository questionRepository;

    public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto)  {

        // Buscar as alternativas das perguntas
        // - Correta ou Incorreta
        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());

        dto.getQuestionAnswers()
                .stream().forEach(questionAnswer -> {
                    var question = questionsEntity.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
                            .findFirst().get();

                    var findCorrectAlternative = question.getAlternatives().stream()
                            .filter(alternative -> alternative.isCorrect()).findFirst().get();

                    if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
                        questionAnswer.setCorrect(true);
                    }
                    else{
                        questionAnswer.setCorrect(false);
                    }
                });
        return dto;
        // Salvar as informações da certificação
    }
}
