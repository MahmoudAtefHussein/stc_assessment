package com.stc_assessment.stc_assessment.dao;

import com.stc_assessment.stc_assessment.entites.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
