package UI.Menus;

import Presenters.StudyHorsePresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHorseMenu extends Menu {

    private final StudyHorsePresenter presenter = new StudyHorsePresenter();

    public StudyHorseMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyTrot, "Обучить бегу рысью"));
        menuItems.add(new MenuItem(this::studyCanter, "Обучить шагу"));
        menuItems.add(new MenuItem(this::studyGallop, "Обучить галопу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHorseNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одного коня/лошади для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные кони/лошади: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyTrot() {
        educate(presenter::learnCommandTrot);
    }

    public void studyCanter() {
        educate(presenter::learnCommandCanter);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void studyGallop() {
        educate(presenter::learnCommandGallop);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}