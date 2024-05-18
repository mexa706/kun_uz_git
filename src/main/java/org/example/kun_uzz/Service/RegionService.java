package org.example.kun_uzz.Service;



import org.example.kun_uzz.DTO.RegionDTO;
import org.example.kun_uzz.Entity.RegionEntity;
import org.example.kun_uzz.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<RegionDTO> getAll() {
        Iterable<RegionEntity> regions = regionRepository.findAll();
        List<RegionDTO> list = new ArrayList<>();
        for (RegionEntity region : regions) {
            RegionDTO regionDTO = new RegionDTO();
            regionDTO.setId(region.getId());
            regionDTO.setCreatedDate(region.getCreatedDate());
            regionDTO.setVisible(region.isVisible());
            regionDTO.setName_uz(region.getName_uz());
            regionDTO.setName_ru(region.getName_ru());
            regionDTO.setName_en(region.getName_en());

        }
    return list;
    }
}
