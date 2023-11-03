package Presenters;

import Application.Services.StudyHamsterService;

import java.util.List;

public class StudyHamsterPresenter {

    private final StudyHamsterService service = new StudyHamsterService();
    public List<String> getAvailableHamsterNames() {
        return service.getAvailableHamsterNames();
    }

    public String learnCommandHide(String name) {
        return service.educateHamsterCommandHide(name);
    }

    public String learnCommandRoll(String name) {
        return service.educateHamsterCommandRoll(name);
    }

    public String learnCommandSpin(String name) {
        return service.educateHamsterCommandSpin(name);
    }
}
