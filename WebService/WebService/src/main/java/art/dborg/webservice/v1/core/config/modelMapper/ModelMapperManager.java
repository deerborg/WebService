package art.dborg.webservice.v1.core.config.modelMapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private final ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
