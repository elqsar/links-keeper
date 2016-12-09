package cz.linkskeeper.users.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {

    String message() default "{Username}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}



