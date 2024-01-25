package UI.Menus;

import Presenters.MainPresenter;
import UI.ConsoleUi;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;

public class MainMenu extends Menu {

    private final MainPresenter presenter;
    public MainMenu() {
        presenter = new MainPresenter();
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showAnimals, "Показать список животных"));
        menuItems.add(new MenuItem(this::addAnimal, "Добавить новое животное"));
        menuItems.add(new MenuItem(this::studyAnimals, "Обучить животное"));
        menuItems.add(new MenuItem(this::quit, "Выйти"));
    }

    public void quit() {
        ConsoleUi.close();
    }

    public void showAnimals() {
        ConsoleUi.println(presenter.getAnimalDetails());
    }

    public void addAnimal() {
        ConsoleUi.setMenu(new AddAnimalMenu());
    }

    public void studyAnimals() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
