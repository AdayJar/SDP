package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.MagazineNotFoundException;
import src.com.librarysystem.models.magazine.Magazine;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MagazineService {
    private final MagazineProvider magazineProvider;

    public MagazineService(MagazineProvider magazineProvider) {
        this.magazineProvider = magazineProvider;
    }

    public boolean isMagazineAvailable(int id) throws MagazineNotFoundException {
        if (!magazineProvider.isMagazineAvailable(id)) {
            throw new MagazineNotFoundException("Magazine with ID " + id + " not found or not available.");
        }
        return true;
    }

    public void changeMagazineAvailability(int id, boolean availability) throws MagazineNotFoundException {
        Magazine magazine = magazineProvider.findById(id);
        if (magazine == null) {
            throw new MagazineNotFoundException("Magazine with ID " + id + " not found.");
        }
        magazineProvider.changeAvailability(id, availability);
    }

    public void openMagazine(int id) throws MagazineNotFoundException, IOException, URISyntaxException {
        Magazine magazine = magazineProvider.findById(id);
        if (magazine == null) {
            throw new MagazineNotFoundException("Magazine with ID " + id + " not found.");
        }

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(magazine.getUrl()));
        } else {
            System.out.println("Desktop не поддерживается на данной платформе.");
        }
    }
}
