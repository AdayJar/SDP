package src.com.librarysystem.visitor;

import src.com.librarysystem.models.magazine.MonthlyMagazine;
import src.com.librarysystem.models.magazine.WeeklyMagazine;


public interface MagazineAcceptor {
    void accept(MonthlyMagazine monthlyMagazine);
    void accept(WeeklyMagazine weeklyMagazine); 
}
