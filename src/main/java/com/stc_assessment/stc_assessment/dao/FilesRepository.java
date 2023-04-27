package com.stc_assessment.stc_assessment.dao;

import com.stc_assessment.stc_assessment.entites.Files;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FilesRepository extends PagingAndSortingRepository<Files, Long> {

    @Transactional
    @Query(value = "SELECT F.* FROM FILES F JOIN ITEM I ON I.ID = F.ITEM_ID JOIN PERMISSION_GROUPS PG " +
            " ON PG.ID = I.PERMISSION_GROUP_ID WHERE F.ID = :fileId AND (SELECT COUNT(1) FROM PERMISSIONS " +
            " WHERE GROUP_ID = PG.ID AND (PERMISSION_LEVEL = 'VIEW' OR PERMISSION_LEVEL = 'EDIT')) > 0" , nativeQuery = true)
    public Files findByFileIdAndGavePermissions(@Param("fileId") Long fileId);
}
