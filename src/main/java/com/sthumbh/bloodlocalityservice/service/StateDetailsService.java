package com.sthumbh.bloodlocalityservice.service;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.exception.StateNotFoundException;

import java.util.Set;

public interface StateDetailsService {
    Set<StateDetailsResponse> getStateDetails();

    Set<DistrictDetailsDto> getDistrictDetails(String stateName) throws DistrictNotFoundException;

    Set<StateDetailsResponse> getState(String stateCode) throws StateNotFoundException;
}
