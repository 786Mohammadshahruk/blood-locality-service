package com.sthumbh.bloodlocalityservice.service.impl;

import com.sthumbh.bloodlocalityservice.dto.AddressDetails;
import com.sthumbh.bloodlocalityservice.service.AddressUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class AddressUploadServiceImpl implements AddressUploadService {
    @Override
    public void uploadAddressDetails() throws IOException, InvalidFormatException {
        String resourcePath = "src/main/resources/addressDetails.xlsx";
        Path absolutePath = Path.of(resourcePath).toAbsolutePath();
        File excelFile = absolutePath.toFile();
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        List<AddressDetails> addressDetailsList = new ArrayList<>();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            if (currentRow.getRowNum() == 0) {
                continue;
            }
            try {
                AddressDetails addressDetails = new AddressDetails();
                addressDetails.setState(currentRow.getCell(0).getStringCellValue());
                addressDetails.setStateCode((int) currentRow.getCell(1).getNumericCellValue());
                addressDetails.setDistrictCode((int) currentRow.getCell(2).getNumericCellValue());
                addressDetails.setDistrictName(currentRow.getCell(3).getStringCellValue());
                addressDetails.setTownCode((int) currentRow.getCell(4).getNumericCellValue());
                addressDetails.setTownName(currentRow.getCell(5).getStringCellValue());
                addressDetailsList.add(addressDetails);
            } catch (Exception exception) {
                log.error("Getting Error while reading Excel : {}", exception.getMessage());
            }


        }
        log.info("Added Size : {}",addressDetailsList.size());

        //read address and save to DB

    }
}
