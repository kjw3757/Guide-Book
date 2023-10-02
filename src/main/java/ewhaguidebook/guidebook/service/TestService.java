package ewhaguidebook.guidebook.service;

import ewhaguidebook.guidebook.dto.AnswerOfTestDTO;
import ewhaguidebook.guidebook.entity.AnswerOfTestEntity;
import ewhaguidebook.guidebook.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestRepository answerOfTestRepository;

    @Autowired
    public TestService(TestRepository answerOfTestRepository) {
        this.answerOfTestRepository = answerOfTestRepository;
    }

    public void saveAnswer(AnswerOfTestDTO answerOfTestDTO) {
        // DTO를 Entity로 변환
        AnswerOfTestEntity answerOfTestEntity = AnswerOfTestEntity.toAnswerOfTestEntity(answerOfTestDTO);
        // Entity를 데이터베이스에 저장
        answerOfTestRepository.save(answerOfTestEntity);
    }
}
