package com.sthumbh.bloodlocalityservice.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public interface AddressUploadService {
    public String uploadAddressDetails() throws IOException, InvalidFormatException;
}
