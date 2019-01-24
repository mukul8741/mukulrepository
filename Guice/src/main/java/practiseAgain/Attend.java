package practiseAgain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation 
@Target({ ElementType.FIELD, ElementType.PARAMETER}) 
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Attend {

}
