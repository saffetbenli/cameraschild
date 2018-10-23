package be.kdg.processor.services;

import be.kdg.processor.dom.Boete;
import be.kdg.processor.exceptions.BoeteException;
import be.kdg.processor.persistence.BoeteRepository;
import com.sun.tools.classfile.Annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Boete load(Long id) throws Exception {
        Optional<Boete> optionalBoete = boeteRepository.findOne(id);
        if(optionalBoete.isPresent()){
            return optionalBoete.get();
        }
        throw new Exception();
    }
}

