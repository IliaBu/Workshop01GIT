package Application.Services;

import Domain.Base.Animal;
import Domain.PackAnimals.Donkey.Donkey;
import Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyDonkeyService extends Service {

    //#region study donkeys
    public List<String> getAvailableDonkeyNames() {
        return farm.getDonkeys().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateDonkeyCommandWalk(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandWalk();
            db.save(farm);
        }
        return output;
    }



    public String educateDonkeyCommandCarryLoad(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandCarryLoad();
            db.save(farm);
        }
        return output;
    }

    public String educateDonkeyCommandBray(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandBray();
            db.save(farm);
        }
        return output;
    }

    public String educateDonkeyCommandKick(String name) {
        Optional<Donkey> result = farm.getDonkeys().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandKick();
            db.save(farm);
        }
        return output;
    }

    //#endregion
}
