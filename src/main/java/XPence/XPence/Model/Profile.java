package XPence.XPence.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(unique = true)
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private String profilePicture;

    @OneToMany(mappedBy = "profile")
    private List<Account> account;

    @OneToOne(targetEntity = MonthlyLimit.class)
    private MonthlyLimit monthLimit;

    public Profile() {
    }

    public Profile(String email, String name, String phoneNumber, String password, String profilePicture, MonthlyLimit monthLimit) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profilePicture = profilePicture;
        this.monthLimit = monthLimit;
    }


    public Long getUserProfileId() {
        return userId;
    }

    public void setUserProfileId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public MonthlyLimit getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(MonthlyLimit monthLimit) {
        this.monthLimit = monthLimit;
    }
}
