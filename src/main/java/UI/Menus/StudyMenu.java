package UI.Menus;

import UI.ConsoleUi;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;

public class StudyMenu extends Menu {
    public StudyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyDogs, "Обучить собак"));
        menuItems.add(new MenuItem(this::studyCats, "Обучить кошек"));
        menuItems.add(new MenuItem(this::studyHamsters, "Обучить хомяков"));
        menuItems.add(new MenuItem(this::studyHorses, "Обучить лошадей"));
        menuItems.add(new MenuItem(this::studyCamels, "Обучить верблюдов"));
        menuItems.add(new MenuItem(this::studyDonkeys, "Обучить ослов"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    public void studyDogs() {
        ConsoleUi.setMenu(new StudyDogMenu());
    }

    public void studyCats() {
        ConsoleUi.setMenu(new StudyCatMenu());
    }

    public void studyHamsters() {
        ConsoleUi.setMenu(new StudyHamsterMenu());
    }

    public void studyHorses() {
        ConsoleUi.setMenu(new StudyHorseMenu());
    }

    public void studyCamels() {
        ConsoleUi.setMenu(new StudyCamelMenu());
    }

    public void studyDonkeys() {
        ConsoleUi.setMenu(new StudyDonkeyMenu());
    }

    public void back() {
        ConsoleUi.setMenu(new MainMenu());
    }
}
