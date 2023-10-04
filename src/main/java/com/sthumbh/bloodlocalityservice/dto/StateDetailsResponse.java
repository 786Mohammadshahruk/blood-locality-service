package com.sthumbh.bloodlocalityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDetailsResponse {
    private String stateName;
    private String stateCode;
}
