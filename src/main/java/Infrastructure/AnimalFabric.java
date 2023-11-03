package Infrastructure;

import Infrastructure.Shared.DateService;
import Domain.Base.Animal;
import Domain.PackAnimals.Camel.Camel;
import Domain.PackAnimals.Donkey.Donkey;
import Domain.PackAnimals.Horse.Horse;
import Domain.Pets.Cat.Cat;
import Domain.Pets.Dog.Dog;
import Domain.Pets.Hamster.Hamster;

import java.util.Collections;
import java.util.List;

public class AnimalFabric {

    public static void fillAnimals(List<Animal> animals) {
        addDogs(animals);
        addCats(animals);
        addHamsters(animals);
        addHorses(animals);
        addCamels(animals);
        addDonkeys(animals);
        shuffle(animals);
    }

    private static void shuffle(List<Animal> animals) {
        Collections.shuffle(animals);
    }

    private static void addDonkeys(List<Animal> animals) {
        Donkey eeyore = Donkey.create("Eeyore", DateService.stringToDate("18-09-2017"));
        eeyore.commandWalk();
        eeyore.commandCarryLoad();
        eeyore.commandBray();
        animals.add(eeyore);

        Donkey burro = Donkey.create("Burro", DateService.stringToDate("23-01-2019"));
        burro.commandWalk();
        burro.commandBray();
        burro.commandKick();
        animals.add(burro);
    }

    private static void addCamels(List<Animal> animals) {
        Camel sandy = Camel.create("Sandy", DateService.stringToDate("03-11-2016"));
        sandy.commandWalk();
        sandy.commandCarryLoad();
        animals.add(sandy);

        Camel dune = Camel.create("Dune", DateService.stringToDate("05-05-2014"));
        dune.commandWalk();
        dune.commandSit();
        animals.add(dune);

        Camel sahara = Camel.create("Sahara", DateService.stringToDate("14-08-2015"));
        sahara.commandWalk();
        sahara.commandRun();
        animals.add(sahara);
    }

    private static void addHorses(List<Animal> animals) {
        Horse thunder = Horse.create("Thunder", DateService.stringToDate("21-07-2015"));
        thunder.commandTrot();
        thunder.commandCanter();
        thunder.commandGallop();
        animals.add(thunder);

        Horse storm = Horse.create("Storm", DateService.stringToDate("05-05-2014"));
        storm.commandTrot();
        storm.commandCanter();
        animals.add(storm);

        Horse blaze = Horse.create("Blaze", DateService.stringToDate("29-02-2016"));
        blaze.commandTrot();
        blaze.commandJump();
        blaze.commandGallop();
        animals.add(blaze);
    }

    private static void addHamsters(List<Animal> animals) {
        Hamster hammy = Hamster.create("Hammy", DateService.stringToDate("10-03-2021"));
        hammy.commandRoll();
        hammy.commandHide();
        animals.add(hammy);

        Hamster peanut = Hamster.create("Peanut", DateService.stringToDate("10-03-2021"));
        peanut.commandRoll();
        peanut.commandSpin();
        animals.add(peanut);
    }

    private static void addCats(List<Animal> animals) {
        Cat whiskers = Cat.create("Whiskers", DateService.stringToDate("15-05-2019"));
        whiskers.commandSit();
        whiskers.commandPounce();
        animals.add(whiskers);

        Cat smudge = Cat.create("Smudge", DateService.stringToDate("15-05-2019"));
        smudge.commandSit();
        smudge.commandPounce();
        smudge.commandScratch();
        animals.add(smudge);

        Cat oliver = Cat.create("Oliver", DateService.stringToDate("30-06-2020"));
        oliver.commandMeow();
        oliver.commandScratch();
        oliver.commandJump();
        animals.add(oliver);
    }

    private static void addDogs(List<Animal> animals) {
        Dog fido = Dog.create("Fido", DateService.stringToDate("01-01-2020"));
        fido.commandSit();
        fido.commandStay();
        fido.commandFetch();
        animals.add(fido);

        Dog buddy = Dog.create("Buddy", DateService.stringToDate("10-12-2018"));
        buddy.commandSit();
        buddy.commandPaw();
        buddy.commandBark();
        animals.add(buddy);

        Dog bella = Dog.create("Bella", DateService.stringToDate("30-06-2020"));
        bella.commandSit();
        bella.commandStay();
        bella.commandRoll();
        animals.add(bella);
    }


}
