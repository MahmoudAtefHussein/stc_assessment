package com.stc_assessment.stc_assessment.controllers;

import com.stc_assessment.stc_assessment.entites.PermissionGroups;
import com.stc_assessment.stc_assessment.services.PermissionGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/permissionGroups", produces = "application/json")
public class PermissionGroupsController {

    @Autowired
    private PermissionGroupsService permissionGroupsService;

    @PostMapping
    public ResponseEntity<?> addPermissionGroups(@RequestBody PermissionGroups permissionGroups) {
        return permissionGroupsService.addPermissionGroups(permissionGroups);
    }
}
