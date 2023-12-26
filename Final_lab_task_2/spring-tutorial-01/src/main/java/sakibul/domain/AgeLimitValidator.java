package sakibul.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeLimitValidator implements ConstraintValidator<AgeLimit, LocalDate> {
    @Override
    public void initialize(AgeLimit constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
       if (dateOfBirth == null){
           return true;
       }
       LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth,today);
        int age = period.getYears();
        return age >= 18;
    }
}
