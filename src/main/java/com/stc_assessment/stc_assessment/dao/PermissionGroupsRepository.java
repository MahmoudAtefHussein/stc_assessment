package com.stc_assessment.stc_assessment.dao;

import com.stc_assessment.stc_assessment.entites.PermissionGroups;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionGroupsRepository extends PagingAndSortingRepository<PermissionGroups, Long> {
}
