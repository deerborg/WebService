package com.example.webservice.v1.core.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperServiceImpl {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
