package UI.Menus;

import Presenters.StudyCamelPresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCamelMenu extends Menu {
    private final StudyCamelPresenter presenter = new StudyCamelPresenter();

    public StudyCamelMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Обучить ходить"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Обучить нести груз"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyRun, "Обучить бежать"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCamelNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одного верблюда для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные верблюды: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyWalk() {
        educate(presenter::learnCommandWalk);
    }

    public void studyCarryLoad() {
        educate(presenter::learnCommandCarryLoad);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyRun() {
        educate(presenter::learnCommandRun);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}