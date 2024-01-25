package UI.Menus;

import Presenters.StudyCatPresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCatMenu extends Menu {
    private final StudyCatPresenter presenter = new StudyCatPresenter();

    public StudyCatMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyPounce, "Обучить идти ко мне"));
        menuItems.add(new MenuItem(this::studyScratch, "Обучить царапать"));
        menuItems.add(new MenuItem(this::studyMeow, "Обучить голосу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCatNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одной кошки для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные коты/кошки: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyPounce() {
        educate(presenter::learnCommandPounce);
    }

    public void studyScratch() {
        educate(presenter::learnCommandScratch);
    }

    public void studyMeow() {
        educate(presenter::learnCommandMeow);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
