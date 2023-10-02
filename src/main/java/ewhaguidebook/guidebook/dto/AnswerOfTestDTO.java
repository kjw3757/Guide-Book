package ewhaguidebook.guidebook.dto;

import ewhaguidebook.guidebook.entity.AnswerOfTestEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnswerOfTestDTO {
    private int id;
    private int answer;
    private int memberAnswer; // 사용자가 선택한 숫자
    private int quizId; // 퀴즈 번호

    public static AnswerOfTestDTO toAnswerOfTestDTO(AnswerOfTestEntity answerOfTestEntity) {
        AnswerOfTestDTO answerOfTestDTO = new AnswerOfTestDTO();
        answerOfTestDTO.setId(answerOfTestEntity.getId());
        answerOfTestDTO.setAnswer(answerOfTestEntity.getAnswer());
        answerOfTestDTO.setMemberAnswer(answerOfTestEntity.getMemberAnswer());
        answerOfTestDTO.setQuizId(answerOfTestEntity.getQuizId());
        return answerOfTestDTO;
    }
}
