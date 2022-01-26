package Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private  String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePicture;
    
    public String register(RegistrationRequest request) {
	return "works";
    }

}
