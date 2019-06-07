package SpringCore.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    /**
     * Can this Validator validate instances of supplied class
     * This Validator validates *only* Person instances
     */
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    /**
     *  Validates the given object and, in case of validation errors, registers those with the given Errors object.
     * @param obj
     * @param e
     */
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
}
