package com.example.pto6.ofc.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Debit implements UserFinance {
    private String name;
    private Long id;
    private Date createDate;
    private Date changeDate;
    private float arrival;
    private TypePeriod typePeriod;
}
