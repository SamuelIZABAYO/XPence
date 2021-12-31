/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XPence.XPence.Service;

import XPence.XPence.Model.ConfirmationToken;
import XPence.XPence.Model.Profile;
import XPence.XPence.Repository.ProfileRepository;
import java.text.MessageFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Crush
 */
@Service
public class ProfileService implements UserDetailsService {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ConfirmationTokenService confirmationTokenService;
    @Autowired
    EmailSenderService emailSenderService;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Profile> profile = profileRepository.findUserByEmail(email);
        if (profile.isPresent()) {
            return profile.get();
        } else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email{0} cannot be found.", email));
        }
    }

    public void signUpUser(Profile profile) {
        final String encryptedPassword = passwordEncoder.encode(profile.getPassword());
        profile.setPassword(encryptedPassword);
        final Profile createdProfile = profileRepository.save(profile);
        final ConfirmationToken confirmationToken = new ConfirmationToken(createdProfile);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
    }

    public void confirmUser(ConfirmationToken confirmationToken) {
        final Profile profile = confirmationToken.getProfile();
        profile.setEnabled(true);
        profileRepository.save(profile);
        confirmationTokenService.deleteConfirmationToken(confirmationToken.getConfirmId());

    }
  public void sendConfirmationMail(String userMail, String token) {

	    final SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(userMail);
	    mailMessage.setSubject("Mail Confirmation Link!");
	    mailMessage.setFrom("<MAIL>");
	    mailMessage.setText(
		    "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="
			    + token);

	    emailSenderService.sendEmail(mailMessage);
	}
}
