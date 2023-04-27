package com.stc_assessment.stc_assessment.services;

import com.stc_assessment.stc_assessment.dao.PermissionGroupsRepository;
import com.stc_assessment.stc_assessment.entites.PermissionGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionGroupsService {

    @Autowired
    private PermissionGroupsRepository permissionGroupsRepository;

    public ResponseEntity<?> addPermissionGroups(PermissionGroups permissionGroups) {
        try {
            if (permissionGroups != null) {
                permissionGroupsRepository.save(permissionGroups);
            }
            return new ResponseEntity<>((List<PermissionGroups>) permissionGroupsRepository.findAll(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> get(PermissionGroups permissionGroups) {
        try {
            if (permissionGroups != null) {
                permissionGroupsRepository.save(permissionGroups);
            }
            return new ResponseEntity<>((List<PermissionGroups>) permissionGroupsRepository.findAll(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
