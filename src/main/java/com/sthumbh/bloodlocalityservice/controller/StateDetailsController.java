package com.sthumbh.bloodlocalityservice.controller;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.exception.StateDetailsValidationException;
import com.sthumbh.bloodlocalityservice.exception.StateNotFoundException;
import com.sthumbh.bloodlocalityservice.model.response.MetaData;
import com.sthumbh.bloodlocalityservice.model.response.ResourceData;
import com.sthumbh.bloodlocalityservice.model.response.StatusCodes;
import com.sthumbh.bloodlocalityservice.model.response.UserResponseModel;
import com.sthumbh.bloodlocalityservice.service.StateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/bbls")
public class StateDetailsController {

    @Autowired
    private StateDetailsService stateDetailsService;

    @GetMapping(value = "/get-all-states")
    public ResponseEntity<UserResponseModel> getStateDetails() {
        ResourceData<Set<StateDetailsResponse>> resourceData = new ResourceData<>();
        resourceData.setData(stateDetailsService.getStateDetails());

        UserResponseModel userResponseModel = UserResponseModel.builder()
                .metaData(new MetaData(StatusCodes.SUCCESS_STATUS, StatusCodes.SUCCESS_CODE, "Success", "v1"))
                .resourceData(resourceData)
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
    }

    @GetMapping(value = "/get-state/{state_code}")
    public ResponseEntity<UserResponseModel> getStateBasedOnStateCode(@PathVariable(name = "state_code") String stateCode) throws StateNotFoundException {
        ResourceData<Set<StateDetailsResponse>> resourceData = new ResourceData<>();
        resourceData.setData(stateDetailsService.getState(stateCode));

        UserResponseModel userResponseModel = UserResponseModel.builder()
                .metaData(new MetaData(StatusCodes.SUCCESS_STATUS, StatusCodes.SUCCESS_CODE, "Success", "v1"))
                .resourceData(resourceData)
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
    }

    @GetMapping(value = "/get-district")
    public ResponseEntity<UserResponseModel> getDistrictDetails(@RequestParam(name = "stateName", required = false) String stateName,
                                                                @RequestParam(name = "stateCode", required = false) String stateCode) throws DistrictNotFoundException, StateDetailsValidationException {
        ResourceData<Set<DistrictDetailsDto>> resourceData = new ResourceData<>();
        resourceData.setData(stateDetailsService.getDistrictDetails(stateName,stateCode));

        UserResponseModel userResponseModel = UserResponseModel.builder()
                .metaData(new MetaData(StatusCodes.SUCCESS_STATUS, StatusCodes.SUCCESS_CODE, "Success", "v1"))
                .resourceData(resourceData)
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
    }

}
