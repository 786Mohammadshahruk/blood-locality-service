package com.sthumbh.bloodlocalityservice.model;


import jakarta.persistence.Column;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

public class DistrictCode {
    public String districtCode;
    public String districtName;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="JSON")
    public List<TownCode> townCodes;
}
