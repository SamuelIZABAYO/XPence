package XPence.XPence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import XPence.XPence.Model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
   
    Optional<ConfirmationToken> findByConfirmationToken(String confirmationToken);

    public void deleteConfirmationTokenById(Long id);
}
