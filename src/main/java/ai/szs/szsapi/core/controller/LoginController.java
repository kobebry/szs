package ai.szs.szsapi.core.controller;


import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.core.model.LoginSetDto;
import ai.szs.szsapi.core.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "GVC - 로그인")
public class LoginController {

    private final LoginService loginService;

    /**
     * GVC - 로그인
     * **/
    @ResponseBody
    @PostMapping("/actLogin")
    @ApiOperation(value = "GVC - 로그인")
    public ResponseObject batiLogin(@RequestBody LoginSetDto loginSetDto){
        return loginService.login(loginSetDto);
    }


}
