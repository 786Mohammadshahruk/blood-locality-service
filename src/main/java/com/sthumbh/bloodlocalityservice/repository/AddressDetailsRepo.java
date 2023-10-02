package com.sthumbh.bloodlocalityservice.repository;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.entity.StateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface AddressDetailsRepo extends JpaRepository<StateDetails, Long> {

    @Query(value = "select * from state_details", nativeQuery = true)
    List<StateDetails> getAllStates();

    @Query(value = "select new com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto(s.districtName) from StateDetails s where stateName =:state_name")
    Set<DistrictDetailsDto> getAllDistrict(@Param("state_name") String stateName);

    @Query(value = "select new com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse(s.stateName) from StateDetails s where stateCode =:stateCode")
    Set<StateDetailsResponse> getState(@Param("stateCode") String stateCode);

}
