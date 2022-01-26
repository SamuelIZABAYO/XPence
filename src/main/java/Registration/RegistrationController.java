package Registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {

    RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request) {
	return registrationService.register(request);
    }
}
