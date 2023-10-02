package ewhaguidebook.guidebook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ewhaguidebook.guidebook.dto.AnswerOfTestDTO;
import ewhaguidebook.guidebook.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/test/start")
    public String showQuizPage() {
        return "test";
    }

    private final TestService TestService;

    @Autowired
    public TestController(TestService TestService) {
        this.TestService = TestService;
    }

    @PostMapping("/save-answer")
    public void saveAnswer(@RequestBody AnswerOfTestDTO answerOfTestDTO) {
        // 클라이언트로부터 받은 데이터를 서비스를 통해 데이터베이스에 저장
        TestService.saveAnswer(answerOfTestDTO);
    }

    @GetMapping("/test/1")
    public String showQuiz1Page() {
        return "test-1";
    }

    @GetMapping("/test/2")
    public String showQuiz2Page() {
        return "test-2";
    }

    @GetMapping("/test/3")
    public String showQuiz3Page() {
        return "test-3";
    }

    @GetMapping("/test/4")
    public String showQuiz4Page() {
        return "test-4";
    }

    @GetMapping("/test/result")
    public String result() {
        return "result";
    }




}
