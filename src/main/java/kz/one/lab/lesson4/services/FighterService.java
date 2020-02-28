package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;

import java.util.List;

public interface FighterService {

    public void addFighter(Fighter fighter);
    public void addFighterToArena(Long arenaId, Long fighterId);

    public List<Fighter> getAllFighters();
}
