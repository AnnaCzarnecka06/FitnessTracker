package myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public myapp.MessageResponce sayhello() {
        return new myapp.MessageResponce(("Witaj, to pierwsze API JASON"), System.currentTimeMillis());
    }
}
