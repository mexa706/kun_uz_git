package org.example.kun_uzz.repository;


import org.example.kun_uzz.Entity.RegionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<RegionEntity, Integer> {

    List<RegionEntity> findAllByVisibleTrueOrderByOrderNumberDesc();

    @Query("from RegionEntity where visible = true order by orderNumber desc")
    List<RegionEntity> findAllVisible();

}
