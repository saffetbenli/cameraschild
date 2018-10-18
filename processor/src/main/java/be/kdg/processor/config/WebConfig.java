package be.kdg.processor.config;

import org.modelmapper.ModelMapper;

public class WebConfig {
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
