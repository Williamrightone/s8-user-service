package cc.synpulse8.userservice.application.impl;

import cc.synpulse8.userservice.application.EndUserService;
import cc.synpulse8.userservice.application.PermissionService;
import cc.synpulse8.userservice.domain.service.EndUserLoginService;
import cc.synpulse8.userservice.presentation.rest.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private EndUserLoginService endUserLoginService;


    @Override
    public RestfulResponse<List<String>> getPermissionListBySid(String sid) {
        return new RestfulResponse<List<String>>(endUserLoginService.getPermissionListBySid(sid));
    }
}
