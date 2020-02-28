package kz.one.lab.lesson4.rest;

import io.swagger.annotations.ApiOperation;
import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import kz.one.lab.lesson4.services.ArenaService;
import kz.one.lab.lesson4.services.CheckingDopingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("arena")
@Slf4j
public class ArenaController {
    // Адрес ednpoint'a=onelab+fight = localhost:port/onelab/fight
    @Autowired
    Arena arena;

    @Autowired
    CheckingDopingService dopingService;

    //////////////////////////////////shto ya dobavil//////////////////////

    @Autowired
    ArenaRepository arenaRepository;

    @Autowired
    FighterRepository fighterRepository;

    ////////////////////////////////////////////////////////////////////////

    //////////////////////////////Eshe shtoto///////////////////////////////////////

    @Autowired
    ArenaService arenaService;

    //////////////////////////////////////////////////////////////////

@ApiOperation("Add Arena")
    @PutMapping(value = "addArena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> addArena(@RequestBody Arena arena)
    {

        System.out.println("Arena id:" +arena.getId());

//        arenaRepository.save(arena);
        arenaService.addArena(arena);

//        List<Arena> arens = arenaRepository.findAll();
        List<Arena> arens = arenaService.getAllArens();

        return new ResponseEntity(arens, HttpStatus.OK);
    }

    @ApiOperation("Delete Arena")
    @DeleteMapping(value = "deleteArena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> deleteArena(@RequestBody Long id)
    {

//        Arena arena = arenaRepository.getOne(id);
//        arenaRepository.delete(arena);
        arenaService.deleteArena(id);

//        List<Arena> arens = arenaRepository.findAll();
        List<Arena> arens = arenaService.getAllArens();

        return new ResponseEntity(arens, HttpStatus.OK);
    }

}
