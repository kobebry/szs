package ai.szs.szsapi.signup.controller;


import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.signup.model.SignUpSetDto;
import ai.szs.szsapi.signup.service.SignUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "szs - 회원가입")
public class SignUpController {

    private final SignUpService signUpService;

    /**
     * szs - 회원가입
     * **/
    @ResponseBody
    @PostMapping("/signup")
    @ApiOperation(value = "szs - 회원가입")
    public ResponseObject signup(@RequestBody SignUpSetDto signUpSetDto){
        return signUpService.signUp(signUpSetDto);
    }
}
