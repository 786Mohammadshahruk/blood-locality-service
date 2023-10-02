package com.sthumbh.bloodlocalityservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MetaData {

    private String status;
    private String code;
    private String message;
    private String version;

}
