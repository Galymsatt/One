package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;

import java.util.List;

public interface ArenaService {

    public void addArena(Arena arena);
    public void deleteArena(Long id);

    public List<Arena> getAllArens();


}
