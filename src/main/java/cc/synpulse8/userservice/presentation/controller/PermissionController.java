package cc.synpulse8.userservice.presentation.controller;

import cc.synpulse8.userservice.application.PermissionService;
import cc.synpulse8.userservice.presentation.rest.RestfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/{sid}")
    public RestfulResponse<List<String>> getPermissionListBySid(@PathVariable String sid) {

        return permissionService.getPermissionListBySid(sid);
    }

}
