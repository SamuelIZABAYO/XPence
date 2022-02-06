package XPence.XPence.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String phoneNumber;

    private String profilePicture;
    private boolean enabled;
    private String verificationCode;

    public Profile() {
	super();
    }

    public Profile(String name, String email, String password, String phoneNumber, String profilePicture,
	    boolean enabled) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.profilePicture = profilePicture;
	this.enabled = enabled;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture() {
	return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public String getVerificationCode() {
	return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
	this.verificationCode = verificationCode;
    }

}
