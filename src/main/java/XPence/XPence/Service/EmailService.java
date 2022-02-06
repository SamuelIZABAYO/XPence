package XPence.XPence.Service;

import XPence.XPence.Model.Profile;

public interface EmailService {

    public void sendVerificationEmail(Profile profile);
}
