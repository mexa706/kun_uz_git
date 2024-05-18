package org.example.kun_uzz.mapper;

import org.example.kun_uzz.DTO.RegionDTO;
import org.example.kun_uzz.Entity.RegionEntity;

public class RegionMapper {

    public static RegionDTO toDTO(RegionEntity entity){
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setName_uz(entity.getName_uz());
        dto.setName_en(entity.getName_en());
        dto.setName_ru(entity.getName_ru());
        dto.setVisible(entity.getVisible());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

  /*  public static RegionDTO toEntity(RegionEntity entity){
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setName_uz(entity.getName_uz());
        dto.setName_en(entity.getName_en());
        dto.setName_ru(entity.getName_ru());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }*/

}
