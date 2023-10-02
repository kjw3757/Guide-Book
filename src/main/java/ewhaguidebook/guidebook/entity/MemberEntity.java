package ewhaguidebook.guidebook.entity;

import ewhaguidebook.guidebook.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)  // unique 제약조건 추가
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private Long memberLevel;

    @Column
    private LocalDate memberBirth;

    @Column
    private Long memberGrade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_member",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> memberGenre;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerOfTestEntity> memberAnswerOfTest;


    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberLevel(memberDTO.getMemberLevel());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberGrade(memberDTO.getMemberGrade());
        memberEntity.setMemberGenre(memberDTO.getMemberGenre());
        memberEntity.setMemberAnswerOfTest(memberDTO.getMemberAnswerOfTest());
        return memberEntity;
    }

    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberLevel(memberDTO.getMemberLevel());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberGrade(memberDTO.getMemberGrade());
        memberEntity.setMemberGenre(memberDTO.getMemberGenre());
        memberEntity.setMemberAnswerOfTest(memberDTO.getMemberAnswerOfTest());
        return memberEntity;
    }
}
