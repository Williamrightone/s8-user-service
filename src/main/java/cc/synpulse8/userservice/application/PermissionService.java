package cc.synpulse8.userservice.application;

import cc.synpulse8.userservice.presentation.rest.RestfulResponse;

import java.util.List;

public interface PermissionService {

    RestfulResponse<List<String>> getPermissionListBySid(String sid);

}
