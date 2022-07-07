package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ReorderRules;

public interface ReorderRulesRepo extends JpaRepository<ReorderRules, Integer>{
	 List<ReorderRules> findByPartPartId(Integer partId);

	 @Modifying
	 @Transactional
	 @Query(value="update `reorderrules` set `maxquantity`=:max,`minquantity`=:min,`reorderfrequency`=:freq where `rrid`=:id",nativeQuery=true)
	void update(@Param("id") Integer Rrid,@Param("min") Integer MinQuantity,@Param("max") Integer MaxQuantity,@Param("freq") Integer ReorderFreq);
}
