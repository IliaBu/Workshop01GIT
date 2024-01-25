package Presenters;

import Application.Services.DetailAnimalService;

public class MainPresenter{
    private final DetailAnimalService service = new DetailAnimalService();

    public String getAnimalDetails(){
        return service.getAnimalDetail();
    }

    public String getAnimalStatistic(){
        return service.getAnimalStatistic();
    }
}
