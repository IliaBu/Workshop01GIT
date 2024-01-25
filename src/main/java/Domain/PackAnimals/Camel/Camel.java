package Domain.PackAnimals.Camel;

import Domain.Base.Animal;
import Domain.Base.PackAnimalType;

import java.util.Date;
import java.util.UUID;

public class Camel extends Animal {
    private Camel(String name, Date birthday) {
        super(UUID.randomUUID(), name, PackAnimalType.CAMEL, birthday);
    }

    public static Camel create(String name, Date birthday) {
        return new Camel(name, birthday);
    }

    public String commandRun() {
        return learnOrExecute(CamelAnimalCommand.commandRun(this.id));
    }

    public String commandCarryLoad() {
        return learnOrExecute(CamelAnimalCommand.commandCarryLoad(this.id));
    }

    public String commandWalk() {
        return learnOrExecute(CamelAnimalCommand.commandWalk(this.id));
    }

    public String commandSit() {
        return learnOrExecute(CamelAnimalCommand.commandSit(this.id));
    }
}
