package com.stc_assessment.stc_assessment.controllers;

import com.stc_assessment.stc_assessment.entites.Permissions;
import com.stc_assessment.stc_assessment.services.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/permissions", produces = "application/json")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    @PostMapping
    public ResponseEntity<?> addUserPermissions(@RequestBody List<Permissions> permissions) {
        return permissionsService.addUserPermissions(permissions);
    }
}
