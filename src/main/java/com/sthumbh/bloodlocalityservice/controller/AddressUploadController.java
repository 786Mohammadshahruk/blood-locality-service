package com.sthumbh.bloodlocalityservice.controller;

import com.sthumbh.bloodlocalityservice.model.response.MetaData;
import com.sthumbh.bloodlocalityservice.model.response.ResourceData;
import com.sthumbh.bloodlocalityservice.model.response.UserResponseModel;
import com.sthumbh.bloodlocalityservice.service.AddressUploadService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/upload")
public class AddressUploadController {

    @Autowired
    private AddressUploadService addressUploadService;

    @PostMapping(value = "/address-details")
    public ResponseEntity<UserResponseModel> uploadAddressDetails(@RequestParam String value) throws IOException, InvalidFormatException {
        addressUploadService.uploadAddressDetails();

        ResourceData<String> resourceData = new ResourceData<>();
        resourceData.setData("Uploaded Success");
        UserResponseModel userResponseModel = UserResponseModel.builder()
                .metaData(new MetaData("200", "200 OK", "Success", "1.0"))
                .resourceData(resourceData)
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
    }
}
