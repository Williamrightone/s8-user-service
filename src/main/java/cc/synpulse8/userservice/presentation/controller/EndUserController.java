package cc.synpulse8.userservice.presentation.controller;

import cc.synpulse8.userservice.application.EndUserService;
import cc.synpulse8.userservice.presentation.dto.UserInfoDto;
import cc.synpulse8.userservice.presentation.rest.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/end-user")
public class EndUserController {

    @Autowired
    private EndUserService endUserService;

    @GetMapping("/{sid}")
    public RestfulResponse<UserInfoDto> getEndUserByEmail(@PathVariable String sid) {

        return endUserService.getEndUserInfoBySid(sid);
    }

}
