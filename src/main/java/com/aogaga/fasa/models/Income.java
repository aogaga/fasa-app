package com.aogaga.fasa.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Income {
    private BigDecimal StudentIncome;
    private BigDecimal parentIncome;
}
