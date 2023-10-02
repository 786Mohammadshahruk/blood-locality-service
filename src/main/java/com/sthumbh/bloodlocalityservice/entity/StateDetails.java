package com.sthumbh.bloodlocalityservice.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String stateName;
    private String stateCode;
    private String districtCode;
    private String districtName;
    private String townCode;
    private String townName;

    //@JdbcTypeCode(SqlTypes.JSON)
    //@Column(columnDefinition="JSON")
}
