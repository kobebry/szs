package ai.szs.szsapi.core.model;

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

    @JsonProperty("mId")
    String mId;

    @JsonProperty("password")
    String password;
}
