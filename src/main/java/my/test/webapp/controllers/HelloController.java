package my.test.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "surname",required = false) String surname,
                             Model model) {
        model.addAttribute("message","Goodbye " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "number1") int num1,
                             @RequestParam(value = "number2") int num2,
                             @RequestParam(value = "action") String action,
                             Model model) {
        int result = 0;
        switch (action) {
            case "addition":
                result = num1 + num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            case "division":
                result = num1 / num2;
                break;
            case "subtraction":
                result = num1 - num2;
                break;
        }
        System.out.println(result);
        model.addAttribute("result", String.valueOf(result));
        return "first/calculator";
    }
}
