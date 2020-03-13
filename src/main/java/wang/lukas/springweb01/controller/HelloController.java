package wang.lukas.springweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: CoffeeChicken
 * @date: 2020/3/10 11:26
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
