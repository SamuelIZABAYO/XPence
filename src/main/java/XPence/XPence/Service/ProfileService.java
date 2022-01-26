/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XPence.XPence.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import XPence.XPence.Model.ConfirmationToken;
import XPence.XPence.Model.Profile;
import XPence.XPence.Repository.ConfirmationTokenRepository;
import XPence.XPence.Repository.ProfileRepository;
import lombok.AllArgsConstructor;

/**
 *
 * @author Crush
 */
@Service
@AllArgsConstructor
public class ProfileService implements UserDetailsService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    EmailSenderService emailSenderService;

    private final static String USER_NOT_FOUND_MESSAGE = "User with email {0} cannot be found.";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	return profileRepository.findByEmail(email)
		.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

//    public void signUpUser(Profile profile) {
//	final String encryptedPassword = bCryptPasswordEncoder.encode(profile.getPassword());
//	profile.setPassword(encryptedPassword);
//	final Profile createdProfile = profileRepository.save(profile);
//	final ConfirmationToken confirmationToken = new ConfirmationToken(createdProfile);
//	confirmationTokenService.saveConfirmationToken(confirmationToken);
//    }
//
//    public void deleteConfirmationToken(Long id) {
//	confirmationTokenRepository.deleteConfirmationTokenById(id);
//    }
//
//    public void confirmUser(ConfirmationToken confirmationToken) {
//	final Profile profile = confirmationToken.getProfile();
//	profile.setEnabled(true);
//	confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
//    }
//
//    public void sendConfirmationEmail(String userEmail, String token) {
//	SimpleMailMessage mailMessage = new SimpleMailMessage();
//	mailMessage.setTo(userEmail);
//	mailMessage.setSubject("My Spring Boot confirmation link!");
//	mailMessage.setFrom("<MAIL>");
//	mailMessage.setText("Thank you for registering. " + "Please click on the below link to activate your account."
//		+ "http://localhost:8080/sign-up/confirm?token=" + token);
//	emailSenderService.sendEmail(mailMessage);
//    }

}
