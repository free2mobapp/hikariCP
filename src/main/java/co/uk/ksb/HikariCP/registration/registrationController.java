package co.uk.ksb.HikariCP.registration;

import co.uk.ksb.HikariCP.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest")
public class registrationController {

    private RegisterService registerService;


    @Autowired
    public registrationController(RegisterService registerService) {
        this.registerService = registerService;
    }


    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public UserRequest register(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.toString());
        registerService.savePerson(userRequest);

        return userRequest;
    }

    @GetMapping(value = "/intro")
    public String intro() {
        System.out.println("Inside intro");
        return "SUCCESS";
    }
}
