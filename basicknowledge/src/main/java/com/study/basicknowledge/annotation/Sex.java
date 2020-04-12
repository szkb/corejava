package com.study.basicknowledge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hangwu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sex {

    public enum GenderType {
        Male("男"),
        Female("女");
        private String genderStr;
        private GenderType(String arg0) {
            this.genderStr = arg0;
        }
        @Override
        public String toString() {
            return genderStr;
        }
    }
    GenderType gender() default GenderType.Male;
}
