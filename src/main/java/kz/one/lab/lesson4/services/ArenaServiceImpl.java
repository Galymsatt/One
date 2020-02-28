package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaServiceImpl implements ArenaService {

    @Autowired
    ArenaRepository arenaRepository;

    @Override
    public void addArena(Arena arena) {
        arenaRepository.save(arena);
    }

    @Override
    public void deleteArena(Long id) {
        Arena arena = arenaRepository.getOne(id);
        arenaRepository.delete(arena);
    }

    @Override
    public List<Arena> getAllArens() {
        List<Arena> arens = arenaRepository.findAll();
        return arens;
    }
}
