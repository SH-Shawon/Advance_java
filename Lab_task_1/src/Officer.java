import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Officer extends Person implements Employee{


    public Officer(String id, String name, LocalDate birthDay, String email, LocalDate joiningDay) {
        super(id, name, birthDay, email, joiningDay);
    }

    @Override
    public double sickLeaveCalculation() {
        LocalDate today = LocalDate.now();
        int thisYear = today.getYear();
        int dayOfThisYear = today.getDayOfYear();
        LocalDate lastDateOfYear = LocalDate.of(thisYear,12,31);
        int daysDifference = (int) ChronoUnit.DAYS.between(getJoiningDay(), lastDateOfYear);
        double leave = (double) ((daysDifference + 1)*10) /dayOfThisYear;
        if (leave < .5)
            return 0;
        else
            return 1;
    }

    @Override
    public double vacationLeaveCalculation() {
        LocalDate today = LocalDate.now();
        int thisYear = today.getYear();
        int dayOfThisYear = today.getDayOfYear();
        LocalDate lastDateOfYear = LocalDate.of(dayOfThisYear,12,31);
        int daysDifference = (int) ChronoUnit.DAYS.between(getJoiningDay(), lastDateOfYear);
        double leave = (double) ((daysDifference + 1)*15)/dayOfThisYear;
        if (leave < .5)
            return 0;
        else
            return 1;
    }
    public void showDetails(){
        super.showDetails();
        this.sickLeaveCalculation();
        this.vacationLeaveCalculation();
    }
}
