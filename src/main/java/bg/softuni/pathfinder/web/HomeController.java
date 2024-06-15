package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        int sofiaTemp = new Random().nextInt(-20, 50);
        int sozopolTemp = new Random().nextInt(-20, 50);
        model.addAttribute("sofiaTemp", sofiaTemp);
        model.addAttribute("sozopolTemp", sozopolTemp);
        return "index";
    }
}
