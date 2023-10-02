package com.sthumbh.bloodlocalityservice.controller;

import com.sthumbh.bloodlocalityservice.dto.DistrictDetailsDto;
import com.sthumbh.bloodlocalityservice.dto.StateDetailsResponse;
import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.model.response.MetaData;
import com.sthumbh.bloodlocalityservice.model.response.ResourceData;
import com.sthumbh.bloodlocalityservice.model.response.StatusCodes;
import com.sthumbh.bloodlocalityservice.model.response.UserResponseModel;
import com.sthumbh.bloodlocalityservice.service.StateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static com.sthumbh.bloodlocalityservice.model.response.StatusCodes.SUCCESS_STATUS;

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

    @GetMapping(value = "/get-district")
    public ResponseEntity<UserResponseModel> getDistrictDetails(@RequestParam(name = "stateName") String stateName) throws DistrictNotFoundException {
        ResourceData<Set<DistrictDetailsDto>> resourceData = new ResourceData<>();
        resourceData.setData(stateDetailsService.getDistrictDetails(stateName));

        UserResponseModel userResponseModel = UserResponseModel.builder()
                .metaData(new MetaData(StatusCodes.SUCCESS_STATUS, StatusCodes.SUCCESS_CODE, "Success", "v1"))
                .resourceData(resourceData)
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
    }

}
