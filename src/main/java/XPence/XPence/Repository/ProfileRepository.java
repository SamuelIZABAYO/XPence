package XPence.XPence.Repository;

import XPence.XPence.Model.Profile;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findUserByEmail(String email);
}
