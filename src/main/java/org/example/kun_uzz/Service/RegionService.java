package org.example.kun_uzz.Service;


import org.example.kun_uzz.DTO.RegionCreateDTO;
import org.example.kun_uzz.DTO.RegionDTO;
import org.example.kun_uzz.Entity.RegionEntity;
import org.example.kun_uzz.Enums.Language;
import org.example.kun_uzz.mapper.RegionMapper;
import org.example.kun_uzz.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public RegionDTO create(RegionCreateDTO dto) {
        RegionEntity entity = new RegionEntity();
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setName_uz(dto.getNameUz());
        entity.setName_ru(dto.getNameRu());
        entity.setName_en(dto.getNameEn());

        regionRepository.save(entity);
        return RegionMapper.toDTO(entity);
    }


    public List<RegionDTO> getAll() {
        Iterable<RegionEntity> regions = regionRepository.findAll();
        List<RegionDTO> list = new ArrayList<>();
        for (RegionEntity region : regions) {
            list.add(RegionMapper.toDTO(region));
        }
        return list;
    }

    public List<RegionDTO> getAllByLang(Language lang) {
        Iterable<RegionEntity> iterable = regionRepository.findAllByVisibleTrueOrderByOrderNumberDesc();
        List<RegionDTO> dtoList = new LinkedList<>();
        for (RegionEntity entity : iterable) {
            RegionDTO dto = new RegionDTO();
            dto.setId(entity.getId());
            switch (lang) {
                case en -> dto.setName(entity.getName_en());
                case uz -> dto.setName(entity.getName_uz());
                case ru -> dto.setName(entity.getName_ru());
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

}
