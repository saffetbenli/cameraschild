package be.kdg.processor.persistence;

import be.kdg.processor.dom.Boete;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BoeteRepository {

    private final ConcurrentHashMap<Integer, Boete> greetingsMap;

    public BoeteRepository() {
        greetingsMap = new ConcurrentHashMap<Integer, Boete>();
    }

    public Boete save(Boete boete) {
        greetingsMap.put(boete.getId(), boete);
        return boete;
    }

    public Optional<Boete> findOne(Long id){
        if(greetingsMap.contains(id)){
            return Optional.of(greetingsMap.get(id));
        }
        return Optional.empty();
    }

}
