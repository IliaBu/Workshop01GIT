package Application.Services;

import Domain.Base.Animal;
import Domain.PackAnimals.Camel.Camel;
import Application.Base.Service;


import java.util.List;
import java.util.Optional;

public class StudyCamelService extends Service {

    //#region study camel
    public List<String> getAvailableCamelNames() {
        return farm.getCamels().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateCamelCommandWalk(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandWalk();
            db.save(farm);
        }
        return output;
    }

    public String educateCamelCommandCarryLoad(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandCarryLoad();
            db.save(farm);
        }
        return output;
    }

    public String educateCamelCommandSit(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSit();
            db.save(farm);
        }
        return output;
    }

    public String educateCamelCommandRun(String name) {
        Optional<Camel> result = farm.getCamels().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRun();
            db.save(farm);
        }
        return output;
    }
    //#endregion

}
