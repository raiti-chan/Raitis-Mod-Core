package com.raitichan.raitismodcore.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * レジストリに登録されないようにするアノテーション
 * <br>Created by Raiti-chan on 2017/10/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonRegister {
}
