package be.kdg.processor.persistence;

import be.kdg.processor.dom.Boete;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BoeteRepository {
    private final ConcurrentHashMap<Long, Boete> boetesMap;

    public BoeteRepository() {
        boetesMap = new ConcurrentHashMap<Long, Boete>();
    }

    public Boete save(Boete boete) {
        boetesMap.put(boete.getId(), boete);
        return boete;
    }

    public Optional<Boete> findOne(Long id){
        if(boetesMap.contains(id)){
            return Optional.of(boetesMap.get(id));
        }
        return Optional.empty();
    }
}
