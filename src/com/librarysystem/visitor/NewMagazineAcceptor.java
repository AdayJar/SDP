package src.com.librarysystem.visitor;

import src.com.librarysystem.models.magazine.MonthlyMagazine;
import src.com.librarysystem.models.magazine.WeeklyMagazine;

import java.util.ArrayList;
import java.util.List;


public class NewMagazineAcceptor implements MagazineAcceptor {
    private List<MonthlyMagazine> monthlyMagazines = new ArrayList<>();
    private List<WeeklyMagazine> weeklyMagazines = new ArrayList<>();

    @Override
    public void accept(MonthlyMagazine monthlyMagazine) {
        monthlyMagazines.add(monthlyMagazine);
        System.out.println("New monthly magazine adopted: " + monthlyMagazine.getTitle());
    }

    @Override
    public void accept(WeeklyMagazine weeklyMagazine) {
        weeklyMagazines.add(weeklyMagazine);
        System.out.println("New weekly magazine adopted: " + weeklyMagazine.getTitle());
    }

   
    public List<MonthlyMagazine> getMonthlyMagazines() {
        return monthlyMagazines;
    }

    public List<WeeklyMagazine> getWeeklyMagazines() {
        return weeklyMagazines;
    }
}
