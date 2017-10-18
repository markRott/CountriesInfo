package com.test.countriesapp.countries;

import com.example.models.CountryDomainModel;
import com.example.usecases.CountriesUseCase;
import com.test.countriesapp.Const;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subscribers.DisposableSubscriber;
import ru.terrakok.cicerone.Router;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.times;

/**
 * Created by sma on 18.10.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class CountriesPresenterTest {

    @Mock
    ICountriesView view;
    @Mock
    ICountriesView$$State viewState;

    Router router;
    CountriesUseCase useCase;
    CountriesPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = Mockito.spy(CountriesPresenter.class);
        router = Mockito.spy(Router.class);
        useCase = Mockito.mock(CountriesUseCase.class);

        presenter.setViewState(viewState);
        presenter.setRouter(router);
        presenter.setCountriesUseCase(useCase);
    }

    @After
    public void tearDown() throws Exception {
        router = null;
        useCase = null;
        presenter = null;
    }

    @Test
    public void openDetailScreen() throws Exception {
        final CountryDomainModel testModel = Mockito.mock(CountryDomainModel.class);
        presenter.openDetailScreen(testModel);
        Mockito
                .verify(router)
                .navigateTo(Const.ScreenKey.DETAIL_COUNTRY, testModel);
    }

    @Test
    public void fetchCountriesIfUseCaseNotEqualNull() {
        presenter.fetchCountries();
        Mockito.verify(viewState, times(1)).showProgressBar();
        Mockito.verify(useCase, times(1)).execute(Mockito.any(DisposableSubscriber.class), (Void) isNull());
    }

    @Test
    public void actionAfterSuccessResponse() {
        final List<CountryDomainModel> mockList = new ArrayList<>();
        final CountryDomainModel model = Mockito.mock(CountryDomainModel.class);
        mockList.add(model);

        presenter.actionAfterSuccessResponse(mockList);
        Mockito.verify(viewState).hideProgressBar();
        Mockito.verify(viewState).renderCountriesList(mockList);
    }

    @Test
    public void actionAfterErrorResponse() {
        presenter.actionAfterErrorResponse(Mockito.anyString());
        Mockito.verify(viewState).hideProgressBar();
        Mockito.verify(viewState).showErrorMessage(Mockito.anyString());
    }

}