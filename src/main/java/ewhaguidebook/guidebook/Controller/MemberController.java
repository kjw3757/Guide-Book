package ewhaguidebook.guidebook.Controller;

import ewhaguidebook.guidebook.dto.MemberDTO;
import ewhaguidebook.guidebook.entity.GenreEntity;
import ewhaguidebook.guidebook.service.GenreService;
import ewhaguidebook.guidebook.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;
    private final GenreService genreService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm(HttpSession session) {
        session.invalidate();
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        session.setAttribute("saveDTO", memberDTO);
        return "genre";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }

    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model사용
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.updateForm(myEmail);
        model.addAttribute("updateMember", memberDTO);
        return "update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getId();
    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @PostMapping("/member/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
    }


    @PostMapping("/member/genre")
    public String register(@RequestParam("selectedGenres") List<String> selectedGenres, HttpSession session) {
        // GenreEntity를 먼저 저장합니다.
        List<GenreEntity> genreEntities = createGenreEntitiesFromNames(selectedGenres);

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("saveDTO");
        memberDTO.setMemberGenre(genreEntities);

        // MemberDTO를 사용하여 회원 정보를 업데이트합니다.
        memberService.save(memberDTO);

        // 회원 가입 완료 후 test/1 페이지로 리다이렉트
        return "major";
    }

    @PostMapping("/member/major")
    public String selectMajor(@RequestBody List<String> selectMajors, HttpSession session) {
        return "test";
    }


    public List<GenreEntity> createGenreEntitiesFromNames(List<String> genreNames) {
        List<GenreEntity> genreEntities = new ArrayList<>();

        for (String genreName : genreNames) {
            GenreEntity genreEntity = new GenreEntity();
            genreEntity.setGenreName(genreName);
            genreEntities.add(genreEntity);
        }
        return genreEntities;
    }



}