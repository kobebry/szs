package ai.szs.szsapi.login.controller;


import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.login.model.LoginSetDto;
import ai.szs.szsapi.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "szs - 로그인")
public class LoginController {

    private final LoginService loginService;

    /**
     * szs - 로그인
     * **/
    @ResponseBody
    @PostMapping("/login")
    @ApiOperation(value = "szs - 로그인")
    public ResponseObject login(@RequestBody LoginSetDto loginSetDto){
        return loginService.login(loginSetDto);
    }


}
