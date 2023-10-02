package ewhaguidebook.guidebook.Controller;

import ewhaguidebook.guidebook.service.BookService;
import ewhaguidebook.guidebook.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookController {
    // 생성자 주입
    private final BookService bookService;

    @GetMapping("/book/search")
    public String searchBook() {
        return "search";
    }

    @GetMapping("book/library")
    public String mylibrary() {
        return "library";
    }
}
