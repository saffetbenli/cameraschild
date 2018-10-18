package be.kdg.processor.controllers.rest;

import be.kdg.processor.Boete.Boete;
import be.kdg.processor.DTO.BoeteDTO;
import be.kdg.processor.exceptions.BoeteException;
import be.kdg.processor.services.BoeteService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BoeteController {

    private final BoeteService boeteService;
    private final ModelMapper modelMapper;


    public BoeteController(BoeteService boeteService, ModelMapper modelMapper){
        this.boeteService = boeteService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/boetes/{id}")
    public ResponseEntity<BoeteDTO> loadGreeting(@PathVariable() Long id) throws BoeteException{
        Boete greeting = boeteService.load(id);
        return new ResponseEntity<>(modelMapper.map(greeting, BoeteDTO.class), HttpStatus.OK);
    }

    @PostMapping("/boetes")
    public ResponseEntity<BoeteDTO> createGreeting(BoeteDTO greetingDTO){
        Boete greeting = modelMapper.map(greetingDTO, Boete.class);
        Boete greetingOut = boeteService.save(greeting);
        return new ResponseEntity<>(modelMapper.map(greetingOut, BoeteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/boetes/{id}")
    public ResponseEntity<BoeteDTO> updateGreeting(@PathVariable Long id, @RequestParam String newContent) throws BoeteException{
        Boete boeteIn = boeteService.load(id);

        boeteIn.setContent(newContent);
        Boete greetingOut = boeteService.save(boeteIn);

        return new ResponseEntity<BoeteDTO>(modelMapper.map(boeteIn, greetingOut), HttpStatus);
    }
}