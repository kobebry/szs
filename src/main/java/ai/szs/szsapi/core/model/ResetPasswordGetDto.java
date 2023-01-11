package ai.szs.szsapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResetPasswordGetDto {

    @JsonProperty("email")
    private String email;

    @JsonProperty("mName")
    private String mName;

    @JsonProperty("password")
    private String password;
}
