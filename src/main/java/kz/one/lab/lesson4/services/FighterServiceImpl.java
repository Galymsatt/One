package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterServiceImpl implements FighterService {

    @Autowired
    ArenaRepository arenaRepository;

    @Autowired
    FighterRepository fighterRepository;

    @Override
    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }

    @Override
    public void addFighterToArena(Long arenaId, Long fighterId) {
        Arena arena = arenaRepository.findById(arenaId).get();
        Fighter fighter = fighterRepository.findById(fighterId).get();

        List<Fighter> arenaFighters= arena.getFighters();
        arenaFighters.add(fighter);
        arena.setFighters(arenaFighters);

        arenaRepository.save(arena);
    }

    @Override
    public List<Fighter> getAllFighters() {
        List<Fighter> fighters = fighterRepository.findAll();
        return fighters;
    }
}
