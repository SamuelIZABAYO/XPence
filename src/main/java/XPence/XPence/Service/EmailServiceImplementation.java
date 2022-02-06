package XPence.XPence.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import XPence.XPence.Model.Profile;

//@Service
public class EmailServiceImplementation implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendVerificationEmail(Profile profile) {
	
    }

}
