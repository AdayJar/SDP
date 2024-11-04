package src.com.librarysystem.adapter;

import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.service.MagazineProvider;

public class MagazineManagerAdapter implements MagazineProvider {
    private final MagazineManager magazineManager;

    public MagazineManagerAdapter(MagazineManager magazineManager) {
        this.magazineManager = magazineManager;
    }

    @Override
    public Magazine findById(int id) {
        return magazineManager.findById(id);
    }

    @Override
    public void changeAvailability(int id, boolean availability) {
        Magazine magazine = magazineManager.findById(id);
        if (magazine != null) {
            magazine.changeAvailability(availability);
        }
    }

    @Override
    public boolean isMagazineAvailable(int id) {
        Magazine magazine = magazineManager.findById(id);
        return magazine != null && magazine.isAvailable();
    }
}
