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
public class LoginGetDto {

    @JsonProperty("mIdx")
    long mIdx;

    @JsonProperty("mId")
    String mId;

    @JsonProperty("email")
    String email;

    @JsonProperty("mName")
    String mName;

    @JsonProperty("memberType")
    String memberType;

}
