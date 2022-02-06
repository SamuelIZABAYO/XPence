package XPence.XPence.Controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import XPence.XPence.Model.Profile;
import XPence.XPence.Service.ProfileService;
import XPence.XPence.Service.Utitlity;

@RestController
public class ProfileController {

//    @Autowired
//    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    ProfileService profileService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Profile profile, HttpServletRequest request)
	    throws UnsupportedEncodingException, MessagingException {

	profileService.registerUser(profile);
	System.out.println(profile.getName());
	System.out.println(profile.getEmail());
	System.out.println(profile.getPassword());
	System.out.println(profile.getPhoneNumber());
	System.out.println(profile.getProfilePicture());
	System.out.println(profile.getVerificationCode());
	String siteURL = Utitlity.getSiteURL(request);
	profileService.sendVerificationEmail(profile, siteURL);

	return "redirect:/sign-in";
    }

//    @RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
//    public String confirmUserAccount(@RequestParam("token") String confirmationToken) {
//
//	ConfirmationToken token = confirmationTokenService.findByToken(confirmationToken);
//	if (token == null) {
//	    return "Wrong token value";
//	}
//	Profile profile = profileRepository.findByEmail(token.getProfile().getEmail());
//	profile.setEnabled(true);
//	profileRepository.save(profile);
//	confirmationTokenService.removeToken(token);
//	return "User verified";
//
//    }

}