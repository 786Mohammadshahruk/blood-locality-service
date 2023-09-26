package com.sthumbh.bloodlocalityservice.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class StateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String state;
    private String stateCode;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="JSON")
    private List<DistrictCode> districtCode;
}
