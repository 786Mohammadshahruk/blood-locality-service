package com.sthumbh.bloodlocalityservice.service.impl;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.entity.StateDetails;
import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.exception.StateDetailsValidationException;
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
            stateDetailsResponseDto.setStateName(i.getStateName());
            stateDetailsResponseDto.setStateCode(i.getStateCode());
            stateDetailsResponseDtoList.add(stateDetailsResponseDto);
        });
        return stateDetailsResponseDtoList;
    }

    @Override
    public Set<DistrictDetailsDto> getDistrictDetails(String stateName, String stateCode) throws DistrictNotFoundException, StateDetailsValidationException {

        Set<DistrictDetailsDto> districtDetailsDto = null;
        if (Objects.nonNull(stateName)) {
            districtDetailsDto = addressDetailsRepo.getAllDistrict(stateName);
        } else if (Objects.nonNull(stateCode)) {
            districtDetailsDto = addressDetailsRepo.getAllDistrictBasedOnStateCode(stateCode);
        }else {
            throw new StateDetailsValidationException("stateName or stateCode should not null or empty");
        }
        if (Objects.isNull(districtDetailsDto)) {
            throw new DistrictNotFoundException("Invalid State / District Not Found");
        }
        return districtDetailsDto;
    }

    @Override
    public Set<StateDetailsResponse> getState(String stateCode) throws StateNotFoundException {
        Set<StateDetailsResponse> state = addressDetailsRepo.getState(stateCode);
        if (Objects.isNull(state)) {
            throw new StateNotFoundException("Invalid State / State Not Found");
        }
        return state;
    }
}
