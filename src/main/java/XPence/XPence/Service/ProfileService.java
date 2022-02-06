/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XPence.XPence.Service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import XPence.XPence.Model.Profile;
import XPence.XPence.Repository.ProfileRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;

import org.springframework.security.core.userdetails.User;

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
    private JavaMailSender mailSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    private ConfirmationTokenService confirmationTokenService;

//    @Autowired
//    ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	final Profile profile = profileRepository.findByEmail(email);
	if (profile == null) {
	    throw new UsernameNotFoundException(email);
	}
	boolean enabled = !profile.isEnabled();
	UserDetails user = User.withUsername(profile.getEmail()).password(profile.getPassword()).disabled(enabled)
		.build();
	return user;
    }

    public Profile registerUser(Profile profile) {
	if (checkIfUserExist(profile.getEmail())) {

	    throw new RuntimeException("User with this email already exists");

	} else {

	    String encryptedPassword = profile.getPassword();
	    profile.setPassword(encryptedPassword);
	    profile.setEnabled(false);
	    profile.setVerificationCode(generateVerificationCode());

	    return profileRepository.save(profile);

	}
    }

    public void sendVerificationEmail(Profile profile, String siteURL)
	    throws UnsupportedEncodingException, MessagingException {

	String subject = "Please verify your registration";
	String senderName = "XPence verify";
	String mailContent = "<p>Dear, " + profile.getName() + " </p><br>";
	mailContent += "<p> Please click the link below to verify your registration: </p><br><br>";

	String verifyURL = siteURL + "/verify?code=" + profile.getVerificationCode();

	mailContent += "<h3><a=\"href=" + verifyURL + "\"> VERIFY YOUR ACCOUNT </a></h3>";

	mailContent += "<p> Thank you <br> XPence Team.";

	MimeMessage message = mailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);

	helper.setFrom("nuer911@gmail.com", senderName);

	helper.setTo(profile.getEmail());
	helper.setSubject(subject);

	helper.setText(mailContent, true);

	mailSender.send(message);
    }

//    public void verifyUser(String token) {
//	ConfirmationToken confirmationToken = confirmationTokenService.findByToken(token);
//	if (confirmationToken != null) {
//	    Profile profile = profileRepository.findByEmail(confirmationToken.getProfile().getEmail());
//	    profile.setEnabled(false);
//	    profileRepository.save(profile);
//	    confirmationTokenService.removeToken(confirmationToken);
//	}
//
//    }

    public boolean checkIfUserExist(String email) {
	return profileRepository.findByEmail(email) != null ? true : false;
    }

    public String generateVerificationCode() {
	String randomCode = RandomString.make(64);
	return randomCode;

    }

    public String encodePassword(String password) {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	String encrypted = bCryptPasswordEncoder.encode(password);
	return encrypted;
    }
}
