package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/greeting/form", method = RequestMethod.POST)
    public String form(@ModelAttribute(value="name") User user, Model model) {

        model.addAttribute("name", user.getName());
        return "forward:/greeting";
    }
}
