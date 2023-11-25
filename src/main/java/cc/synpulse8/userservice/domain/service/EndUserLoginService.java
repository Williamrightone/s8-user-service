package cc.synpulse8.userservice.domain.service;

import cc.synpulse8.userservice.presentation.dto.UserInfoDto;

import java.util.List;

public interface EndUserLoginService {

    public UserInfoDto getEndUserInfoBySid(String sid);

    public List<String> getPermissionListBySid(String sid);

}
