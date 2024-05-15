package art.dborg.webservice.v1.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequest {

    @NotEmpty(message = "Username not null")
    private String username;

    @Email(message = "Bad Email format")
    @NotEmpty(message = "Email not null")
    private String email;

    @NotEmpty(message = "Password not null")
    private String password;
}
