package com.test.countriesapp.dagger2.countries;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sma on 10.10.17.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface CountriesScope {
}
