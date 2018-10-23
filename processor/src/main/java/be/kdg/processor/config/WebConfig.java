package be.kdg.processor.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
