package cc.synpulse8.userservice.application.impl;

import cc.synpulse8.userservice.application.EndUserService;
import cc.synpulse8.userservice.domain.service.EndUserLoginService;
import cc.synpulse8.userservice.presentation.dto.UserInfoDto;
import cc.synpulse8.userservice.presentation.rest.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndUserServiceImpl implements EndUserService {

    @Autowired
    private EndUserLoginService endUserLoginService;

    @Override
    public RestfulResponse<UserInfoDto> getEndUserInfoBySid(String sid) {

        return new RestfulResponse<>(endUserLoginService.getEndUserInfoBySid(sid));
    }
}
