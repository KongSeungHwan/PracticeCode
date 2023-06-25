package com.matchgetit.backend.service;

import com.matchgetit.backend.dto.StadiumDTO;
import com.matchgetit.backend.repository.StadiumRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StadiumService {
    private final StadiumRepository stadiumRepository;
    private final ModelMapper modelMapper;
    public List<StadiumDTO> findAllStadiums(){
        return stadiumRepository.findAll().stream().map(s->modelMapper.map(s,StadiumDTO.class)).toList();
    }

}
