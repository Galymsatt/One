package kz.one.lab.lesson4.rest;

import io.swagger.annotations.ApiOperation;
import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repositories.ArenaRepository;
import kz.one.lab.lesson4.repositories.FighterRepository;
import kz.one.lab.lesson4.services.ArenaService;
import kz.one.lab.lesson4.services.CheckingDopingService;
import kz.one.lab.lesson4.services.FighterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("onelab")
@Slf4j
public class FightController {
    // Адрес ednpoint'a=onelab+fight = localhost:port/onelab/fight

//    @Autowired
//    Arena arena;

    @Autowired
    CheckingDopingService dopingService;

    //////////////////////////////////shto ya dobavil//////////////////////

    @Autowired
    ArenaRepository arenaRepository;

    @Autowired
    FighterRepository fighterRepository;

    ////////////////////////////////////////////////////////////////////////

    /////////////////////////////eshe///////////////////////////////////

    @Autowired
    FighterService fighterService;

    @Autowired
    ArenaService arenaService;


    ////////////////////////////////////////////////////////////////////////

//    @PostConstruct//Ne ponyal, sprosyt esli bez etogo nikak
//    public void test(){
//        arenaRepository.save(new Arena());
//    }


//    @ApiOperation("Add Fighter")
//    @PutMapping(value = "fight", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Arena> helloOneLab(@RequestBody Fighter fighter)
//    {
//
//        Fighter resp = fighterRepository.save(fighter);
//
//        //arena.getFighters().add(fighter);
////        Arena arena = arenaRepository.getOne(2L);
//        Arena arena1 = arenaRepository.findAll().get(0);
////        List<Arena> arenas = arenaRepository.findAll();
////        for(Arena a : arenas)
////            System.out.println("Arena id, name: "+a.getId()+", "+a.getName());
//        arena1.getFighters().add(resp);
//        arenaRepository.save(arena1);
//
//
//        log.info("test: "+arena1.getFighters());
//        //System.out.println("test printpen: "+arena.getFighters());
//        return new ResponseEntity(arena1.getFighters(), HttpStatus.OK);
//    }

//    @ApiOperation("Check All Fighters")
//    @PostMapping(value = "check", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Fighter> check(){
//
//        Arena arena = arenaRepository.findAll().get(0);
//
//        List<Fighter> fighters =arena.getFighters();
//        //вывели имена всех бойсов в арене, при этом не меняя нижнюю строку
//        log.info("Our warriors: "+arena.getFighters().toString());//вот эту
//        // выбросить в лузеров из бойцов всех тех, кто не прошел допинг контроль
//
////        List<Fighter> losers = new ArrayList<>();
//        Arena losers = arenaRepository.findAll().get(1);
//
////        for(Fighter f : fighters)//Добавление в лузеры
////            if(dopingService.checkFigher(f)) {
////                losers.add(f);
////            }
//
//        fighters.removeIf(fighter ->
//        {
//            if(!dopingService.checkFigher(fighter)){
//                losers.getFighters().add(fighter);
//                return true;
//            }
//            else
//                return false;
//        });
//        arenaRepository.save(losers);
//
//        arena.setFighters(fighters);
//        arenaRepository.save(arena);
//
//        return losers.getFighters();
//    }


//    @ApiOperation("Add Arena")
//    @PutMapping(value = "addArena", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Arena> addArena(@RequestBody Arena arena)
//    {
//
//        System.out.println("Arena id:" +arena.getId());
//
//        arenaRepository.save(arena);
//        List<Arena> arens = arenaRepository.findAll();
//
//        return new ResponseEntity(arens, HttpStatus.OK);
//    }
//
//    @ApiOperation("Delete Arena")
//    @DeleteMapping(value = "deleteArena", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Arena> deleteArena(@RequestBody Long id)
//    {
//
//        Arena arena = arenaRepository.getOne(id);
//        arenaRepository.delete(arena);
//
//        List<Arena> arens = arenaRepository.findAll();
//
//        return new ResponseEntity(arens, HttpStatus.OK);
//    }


    @ApiOperation("Add Fighter New Way")
    @PutMapping(value = "addFighterNewWay", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> addFighterNewWay(@RequestBody Fighter fighter)
    {
//        Fighter resp = fighterRepository.save(fighter);
        fighterService.addFighter(fighter);

//        List<Fighter> fighters = fighterRepository.findAll();
        List<Fighter> fighters = fighterService.getAllFighters();

        return new ResponseEntity(fighters, HttpStatus.OK);
    }

    @ApiOperation("Add Fighter To Arena")
    @PutMapping(value = "addFighterToArena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> addFighterNewWay(@RequestParam Long arenaId,
                                                  @RequestParam Long fighterId) {

//        Arena arena = arenaRepository.findById(arenaId).get();
//        Fighter fighter = fighterRepository.findById(fighterId).get();
//
//        List<Fighter> arenaFighters= arena.getFighters();
//        arenaFighters.add(fighter);
//        arena.setFighters(arenaFighters);
//
//        arenaRepository.save(arena);
        fighterService.addFighterToArena(arenaId, fighterId);


//        List<Arena> arens = arenaRepository.findAll();
        List<Arena> arens = arenaService.getAllArens();

        return new ResponseEntity(arens, HttpStatus.OK);
    }
}
