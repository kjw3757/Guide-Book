package ewhaguidebook.guidebook.Controller;

import ewhaguidebook.guidebook.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUid("Hello");
            user.setPw("World");
            userList.add(user);
        }

        model.addAttribute("userList", userList);
        return "welcome";
    }
}
