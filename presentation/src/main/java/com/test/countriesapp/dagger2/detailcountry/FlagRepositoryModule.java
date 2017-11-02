package com.test.countriesapp.dagger2.detailcountry;

import com.example.interfaces.ICountryFlagRepository;
import com.example.models.CountryDomainModel;
import com.example.sma.data.IApplicationApi;
import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;
import com.example.sma.data.repositories.countryflag.CountryFlagRepositoryImpl;
import com.example.sma.data.repositories.countryflag.FlagDataFactory;
import com.orhanobut.logger.Logger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 18.10.17.
 */

@Module
public class FlagRepositoryModule {

    private final String flagUrl;
    private final CountryDomainModel countryDomainModel;

    public FlagRepositoryModule(final CountryDomainModel model) {
        this.countryDomainModel = model;
        flagUrl = buildFlagUrl();
        Logger.i(flagUrl);
        countryDomainModel.setUrlForLoadFlag(flagUrl);
    }

    @Provides
    @DetailCountryScope
    public CountryDomainModel provideCountryDomainModel() {
        return countryDomainModel;
    }

    @Provides
    @DetailCountryScope
    public FlagDataFactory provideFlagDataFactory(LruCacheForCountryFlagImpl cache) {
        return new FlagDataFactory(flagUrl, cache);
    }

    @Provides
    @DetailCountryScope
    public ICountryFlagRepository provideCountryFlagRepository(FlagDataFactory flagDataFactory) {

        return new CountryFlagRepositoryImpl(flagUrl, flagDataFactory);
    }

    private String buildFlagUrl() {
        return new StringBuilder()
                .append(IApplicationApi.BASE_URL_FOR_FLAG_IMAGE)
                .append(countryDomainModel.getAlpha3Code().toLowerCase())
                .append(IApplicationApi.SVG)
                .toString();
    }

}
