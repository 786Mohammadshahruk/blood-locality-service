package com.sthumbh.bloodlocalityservice.exception.handler;

import com.sthumbh.bloodlocalityservice.exception.DistrictNotFoundException;
import com.sthumbh.bloodlocalityservice.exception.StateNotFoundException;
import com.sthumbh.bloodlocalityservice.model.response.MetaData;
import com.sthumbh.bloodlocalityservice.model.response.StatusCodes;
import com.sthumbh.bloodlocalityservice.model.response.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<UserResponseModel> districtNotFoundException(DistrictNotFoundException exception) {
        MetaData metaData = MetaData.builder()
                .code(StatusCodes.BUSINESS_ERROR_CODE)
                .message(exception.getMessage())
                .status(StatusCodes.BUSINESS_ERROR_STATUS)
                .version("1.0")
                .build();
        UserResponseModel responseModel = UserResponseModel.builder().metaData(metaData).build();
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StateNotFoundException.class)
    public ResponseEntity<UserResponseModel> stateNotFoundException(StateNotFoundException exception) {
        MetaData metaData = MetaData.builder()
                .code(StatusCodes.BUSINESS_ERROR_CODE)
                .message(exception.getMessage())
                .status(StatusCodes.BUSINESS_ERROR_STATUS)
                .version("1.0")
                .build();
        UserResponseModel responseModel = UserResponseModel.builder().metaData(metaData).build();
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
}
