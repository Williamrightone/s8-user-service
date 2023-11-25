package cc.synpulse8.userservice.domain.service.impl;

import cc.synpulse8.userservice.domain.error.UserServiceException;
import cc.synpulse8.userservice.domain.model.entity.EndUserEntity;
import cc.synpulse8.userservice.domain.repository.EndUserEntityRepository;
import cc.synpulse8.userservice.domain.repository.PermissionRepository;
import cc.synpulse8.userservice.domain.service.EndUserLoginService;
import cc.synpulse8.userservice.presentation.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EndUserLoginServiceImpl implements EndUserLoginService {

    @Autowired
    private EndUserEntityRepository endUserEntityRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserInfoDto getEndUserInfoBySid(String sid) {

        EndUserEntity endUserEntity = endUserEntityRepository.findBySid(sid).orElseThrow(() -> new UserServiceException(UserServiceException.UserServiceErrorType.USER_NOT_FOUND, "User Not Found"));

        UserInfoDto userInfoDto = new UserInfoDto();

        userInfoDto.setUserName(endUserEntity.getUserName());
        userInfoDto.setPasswd(endUserEntity.getPasswd());
        userInfoDto.setSid(endUserEntity.getSid());

        return userInfoDto;
    }

    @Override
    public List<String> getPermissionListBySid(String sid) {

        List<String> permissions = permissionRepository.findPermissionBySid(sid);

        if(permissions.isEmpty()){
            throw new UserServiceException(UserServiceException.UserServiceErrorType.USER_NO_ANY_PERMISSION, "User No Any Permission");
        }

        return permissions;
    }
}
