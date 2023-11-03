package Application.Base;

import Infrastructure.AnimalFabric;

import Infrastructure.DB.Db;
import Infrastructure.Farm;
import Infrastructure.DB.AnimalDb;


public abstract class Service {
    protected final Farm farm;
    protected final Db<Farm> db = new AnimalDb();

    protected Service() {
        farm = db.load();
        if (farm.getAllAnimals().isEmpty()) {
            AnimalFabric.fillAnimals(farm.getAllAnimals());
            db.save(farm);
        }
    }
}
