package be.kdg.processor.controllers.rest;

import be.kdg.processor.config.WebConfig;
import be.kdg.processor.dom.Boete;
import be.kdg.processor.DTO.BoeteDTO;
import be.kdg.processor.exceptions.BoeteException;
import be.kdg.processor.services.BoeteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BoeteController {
    /*
    private final BoeteService boeteService;
    private final ModelMapper modelMapper;

    public BoeteController(BoeteService boeteService, ModelMapper modelMapper){
        this.boeteService = boeteService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/boetes/{id}")
    public ResponseEntity<BoeteDTO> loadBoete(@PathVariable() Long id) throws Exception {
        Boete boete = boeteService.load(id);
        return new ResponseEntity<>(modelMapper.map(boete, BoeteDTO.class), HttpStatus.OK);
    }

    @PostMapping("/boetes")
    public ResponseEntity<BoeteDTO> createBoete(BoeteDTO boeteDTO){
        Boete boete = modelMapper.map(boeteDTO, Boete.class);
        Boete boeteOut = boeteService.save(boete);
        return new ResponseEntity<>(modelMapper.map(boeteOut, BoeteDTO.class), HttpStatus.CREATED);
    }

    /*
    @PutMapping("/boetes/{id}")
    public ResponseEntity<BoeteDTO> updateBoete(@PathVariable Long id, @RequestParam String newContent) throws BoeteException{
        Boete boeteIn = boeteService.load(id);

        boeteIn.setBoeteType(newContent);
        Boete boeteOut = boeteService.save(boeteIn);

        return new ResponseEntity<BoeteDTO>(modelMapper.map(boeteIn, boeteOut, HttpStatus.CREATED));
    }*/
}