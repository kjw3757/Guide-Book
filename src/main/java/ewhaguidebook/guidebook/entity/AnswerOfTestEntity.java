package ewhaguidebook.guidebook.entity;

import ewhaguidebook.guidebook.dto.AnswerOfTestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AnswerOfTestEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private int answer; // 정답

    @Column
    private int memberAnswer; // 사용자가 선택한 숫자

    @Column
    private int quizId; // 퀴즈 번호

    @ManyToOne // 다대일(Many-to-One) 관계 설정
    @JoinColumn(name = "member_id") // 외래 키 컬럼 이름을 "member_id"로 설정
    private MemberEntity memberEntity;

    public static AnswerOfTestEntity toAnswerOfTestEntity(AnswerOfTestDTO answerOfTestDTO) {
        AnswerOfTestEntity answerOfTestEntity = new AnswerOfTestEntity();
        answerOfTestEntity.setAnswer(answerOfTestDTO.getAnswer());
        answerOfTestEntity.setMemberAnswer(answerOfTestDTO.getMemberAnswer());
        answerOfTestEntity.setQuizId(answerOfTestDTO.getQuizId());

        return answerOfTestEntity;
    }
}
