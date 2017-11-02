package com.test.countriesapp.dagger2.detailcountry;

import com.example.interfaces.ICountryFlagRepository;
import com.example.models.CountryDomainModel;
import com.example.usecases.CountryFlagUseCase;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.detailcountry.DetailCountryPresenter;

import dagger.Component;

/**
 * Created by sma on 18.10.17.
 */

@DetailCountryScope
@Component(
        dependencies = MyAppComponent.class,
        modules = {
                FlagRepositoryModule.class,
                FlagUseCaseModule.class,
        })
public interface DetailCountryComponent {

    void inject(DetailCountryPresenter presenter);

    CountryDomainModel countryDomainModel();

    ICountryFlagRepository countryFlagRepository();

    CountryFlagUseCase countryFlagUseCase();
}
