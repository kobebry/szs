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
public class SocialLoginSetDto {

    @JsonProperty("email")
    String email;

    @JsonProperty("accessToken")
    String accessToken;

    @JsonProperty("socialType")
    String socialType;

    @JsonProperty("mName")
    String mName;
}
