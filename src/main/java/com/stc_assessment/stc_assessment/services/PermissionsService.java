package com.stc_assessment.stc_assessment.services;

import com.stc_assessment.stc_assessment.dao.PermissionRepository;
import com.stc_assessment.stc_assessment.entites.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsService {

    @Autowired
    private PermissionRepository permissionRepository;

    public ResponseEntity<?> addUserPermissions(List<Permissions> permissions) {
        try {
            if (permissions != null) {
                permissionRepository.saveAll(permissions);
            }
            return new ResponseEntity<>((List<Permissions>) permissionRepository.findAll(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<Permissions> getGroupPermissions(Long groupId) {
        return permissionRepository.findByPermissionGroupId(groupId);
    }
}
