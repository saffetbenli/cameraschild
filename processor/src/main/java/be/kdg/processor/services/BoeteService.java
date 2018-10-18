package be.kdg.processor.services;

import be.kdg.processor.Boete.Boete;
import be.kdg.processor.exceptions.BoeteException;
import be.kdg.processor.persistence.BoeteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BoeteService {
    private final BoeteRepository boeteRepository;
    private AtomicLong counter = new AtomicLong();


    public BoeteService(BoeteRepository boeteRepository) {
        this.boeteRepository = boeteRepository;
    }

    public Boete save(Boete boete){
        if(boete.getId() == null){
            boete.setId(counter.incrementAndGet());
        }
        return boeteRepository.save(boete); //elke keer als ge iets saved, terugsturen voor persistentie
    }

    public Boete load(Long id){
        Optional<Boete> optionalGreeting = boeteRepository.findOne(id);
        if(optionalGreeting.isPresent()){
            return optionalGreeting.get();
        }
        throw new BoeteException("Boete not found");
    }

}
