package com.stc_assessment.stc_assessment.dao;

import com.stc_assessment.stc_assessment.entites.Permissions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permissions, Long> {

    List<Permissions> findByPermissionGroupId(Long groupId);
}
