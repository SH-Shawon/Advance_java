package sakibul.domain;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AgeLimitValidator.class)
public @interface AgeLimit {
    String message() default "You have to be at least 18 years old to registered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
