package XPence.XPence.Controller;

import XPence.XPence.Model.ConfirmationToken;
import XPence.XPence.Model.Profile;
import XPence.XPence.Service.ConfirmationTokenService;
import XPence.XPence.Service.ProfileService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(Profile profile) {
        profileService.signUpUser(profile);

        return "redirect:/sign-in";
    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") String token) {
        Optional<ConfirmationToken> confirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
        confirmationToken.ifPresent(profileService::confirmUser);
        return "/sign-in";
    }

}
