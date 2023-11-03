package UI.Menus;

import Presenters.AddAnimalPresenter;
import UI.ConsoleUi;
import Infrastructure.Shared.ICreatable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.Date;

public class AddAnimalMenu extends Menu {
    private final AddAnimalPresenter presenter = new AddAnimalPresenter();

    public AddAnimalMenu() {

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::addDog, "Добавить собаку"));
        menuItems.add(new MenuItem(this::addCat, "Добавить кошку"));
        menuItems.add(new MenuItem(this::addHamster, "Добавить хомяка"));
        menuItems.add(new MenuItem(this::addHorse, "Добавить лошадь"));
        menuItems.add(new MenuItem(this::addCamel, "Добавить верблюда"));
        menuItems.add(new MenuItem(this::addDonkey, "Добавить осла"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    public void back() {
        ConsoleUi.setMenu(new MainMenu());
    }

    private void addAnimal(ICreatable creator) {
        ConsoleUi.println("Введите имя: (мин. 3 буквы)");
        String name = ConsoleUi.getStringInput(3);
        ConsoleUi.println("Введите дату рождения: (формат: 'дд-мм-гггг')");
        Date birthday = ConsoleUi.getDateInput();
        creator.invoke(name, birthday);
    }

    public void addCat() {
        addAnimal(presenter::addCat);
    }

    public void addDog() {
        addAnimal(presenter::addDog);
    }

    public void addHamster() {
        addAnimal(presenter::addHamster);
    }

    public void addHorse() {
        addAnimal(presenter::addHorse);
    }

    public void addCamel() {
        addAnimal(presenter::addCamel);
    }

    public void addDonkey() {
        addAnimal(presenter::addDonkey);
    }
}
