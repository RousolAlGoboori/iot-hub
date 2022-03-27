package com.cs490.iothub.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Creating a custom annotation with target
// as TYPE which means it can annotate a class,
// enumeration, or interface
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:get current ElementType of specific annotation
 */
public @interface DateField {
}
