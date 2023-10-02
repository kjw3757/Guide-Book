package ewhaguidebook.guidebook.dto;

import ewhaguidebook.guidebook.entity.AnswerOfTestEntity;
import ewhaguidebook.guidebook.entity.GenreEntity;
import ewhaguidebook.guidebook.entity.MemberEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Long memberLevel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate memberBirth;

    private Long memberGrade;
    private List<GenreEntity> memberGenre;
    private List<AnswerOfTestEntity> memberAnswerOfTest;
    public MemberDTO() {

    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberLevel(memberEntity.getMemberLevel());
        memberDTO.setMemberBirth(memberEntity.getMemberBirth());
        memberDTO.setMemberGrade(memberEntity.getMemberGrade());
        memberDTO.setMemberGenre(memberEntity.getMemberGenre());
        memberDTO.setMemberAnswerOfTest(memberEntity.getMemberAnswerOfTest());
        return memberDTO;
    }
}
