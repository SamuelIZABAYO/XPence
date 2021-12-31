package XPence.XPence.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XPence.XPence.Model.ConfirmationToken;
import XPence.XPence.Repository.ConfirmationTokenRepository;
import java.util.Optional;

@Service
public class ConfirmationTokenService {

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
	super();
	this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken confirmationToken) {

	confirmationTokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {

	return confirmationTokenRepository.findConfirmationTokenById(token);
    }

    public void deleteConfirmationToken(Long id) {
	confirmationTokenRepository.deleteById(id);
    }
}
