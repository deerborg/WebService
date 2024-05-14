package art.dborg.webservice.v1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequest {

    @NotNull(message = "Username not null")
    private String username;

    @Email
    @NotNull(message = "Email not null")
    private String email;

    @NotNull(message = "Password not null")
    private String password;
}
