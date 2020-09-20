package com.study.basicknowledge.basicjava.annotation;

import java.lang.annotation.*;

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
