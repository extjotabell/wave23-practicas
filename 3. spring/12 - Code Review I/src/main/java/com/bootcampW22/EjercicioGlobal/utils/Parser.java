package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.DimensioneDto;

public class Parser {

    public static DimensioneDto getFilterFromStringToInt(String lengthRange, String widthRange){
        double minLenght = Integer.parseInt(lengthRange.split("-")[0]);
        double maxLenght = Integer.parseInt(lengthRange.split("-")[1]);
        double minWidth = Integer.parseInt(widthRange.split("-")[0]);
        double maxWidth = Integer.parseInt(widthRange.split("-")[1]);
        return new DimensioneDto(minLenght,maxLenght,minWidth,maxWidth);
    }
}
