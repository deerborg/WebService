package com.example.webservice.v1.core.config.modelMapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelMapperService implements ModelMapperServiceImpl{

    private final ModelMapper mapper;

    @Override
    public ModelMapper forResponse() {
        mapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper;
    }

    @Override
    public ModelMapper forRequest() {
        mapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
}
