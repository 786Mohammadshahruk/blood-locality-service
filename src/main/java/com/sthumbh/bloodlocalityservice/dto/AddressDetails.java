package com.sthumbh.bloodlocalityservice.dto;

import lombok.Data;

@Data
public class AddressDetails {
    private String stateName;
    private int stateCode;
    private int districtCode;
    private String districtName;
    private int townCode;
    private String townName;

}
