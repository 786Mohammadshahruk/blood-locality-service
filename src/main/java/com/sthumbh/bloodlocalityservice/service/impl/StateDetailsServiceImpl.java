package com.sthumbh.bloodlocalityservice.service.impl;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.entity.StateDetails;
import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.exception.StateNotFoundException;
import com.sthumbh.bloodlocalityservice.repository.AddressDetailsRepo;
import com.sthumbh.bloodlocalityservice.service.StateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StateDetailsServiceImpl implements StateDetailsService {

    @Autowired
    private AddressDetailsRepo addressDetailsRepo;

    @Override
    public Set<StateDetailsResponse> getStateDetails() {
        List<StateDetails> stateDetails = addressDetailsRepo.getAllStates();
        Set<StateDetailsResponse> stateDetailsResponseDtoList = new HashSet<>();
        stateDetails.stream().forEach(i -> {
            StateDetailsResponse stateDetailsResponseDto = new StateDetailsResponse();
            stateDetailsResponseDto.setStatesName(i.getStateName());
            stateDetailsResponseDtoList.add(stateDetailsResponseDto);
        });
        return stateDetailsResponseDtoList;
    }

    @Override
    public Set<DistrictDetailsDto> getDistrictDetails(String stateName) throws DistrictNotFoundException {
        Set<DistrictDetailsDto> districtDetailsDto = addressDetailsRepo.getAllDistrict(stateName);
        if (Objects.isNull(districtDetailsDto)) {
            throw new DistrictNotFoundException("Invalid State / District Not Found");
        }
        return districtDetailsDto;
    }

    @Override
    public Set<StateDetailsResponse> getState(String stateCode) throws StateNotFoundException {
        Set<StateDetailsResponse> state =  addressDetailsRepo.getState(stateCode);
        if(Objects.isNull(state)){
            throw new StateNotFoundException("Invalid State / State Not Found");
        }
        return state;
    }
}
