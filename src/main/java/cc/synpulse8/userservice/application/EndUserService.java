package cc.synpulse8.userservice.application;

import cc.synpulse8.userservice.presentation.dto.UserInfoDto;
import cc.synpulse8.userservice.presentation.rest.RestfulResponse;

public interface EndUserService {

    public RestfulResponse<UserInfoDto> getEndUserInfoBySid(String sid);

}
