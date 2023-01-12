package ai.szs.szsapi.core.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSetDto {

    @JsonProperty("userId")
    String userId;

    @JsonProperty("password")
    String password;
}
