package com.test.countriesapp.detailcountry;

import com.example.usecases.CountryFlagUseCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.subscribers.DisposableSubscriber;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

/**
 * Created by sma on 18.10.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class DetailCountryPresenterTest {

    @Mock
    IDetailCountryView view;
    @Mock
    IDetailCountryView$$State viewState;

    CountryFlagUseCase useCase;
    DetailCountryPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = Mockito.spy(DetailCountryPresenter.class);
        useCase = Mockito.mock(CountryFlagUseCase.class);
        presenter.setViewState(viewState);
        presenter.setCountryFlagUseCase(useCase);
    }

    @After
    public void tearDown() throws Exception {
        useCase = null;
        presenter = null;
        view = null;
        viewState = null;
    }

    @Test
    public void loadCountryFlagUrlNotContainAlpha3Code() throws Exception {
        presenter.loadCountryFlagInSvgFormat(Mockito.anyString());
        Mockito.verify(useCase, never())
                .execute(any(DisposableSubscriber.class), (Void) isNull());
    }

    @Test
    public void loadCountryFlagUrlContainAlpha3Code() throws Exception {
        final String alpha3Code = "afg";
        presenter.loadCountryFlagInSvgFormat(alpha3Code);

        Mockito.verify(useCase, times(1))
                .execute(any(DisposableSubscriber.class), (Void) isNull());
    }

    @Test
    public void actionAfterSuccessResponse() {
        final byte[] byteArray = new byte[1];
        presenter.actionAfterSuccessResponse(byteArray);

        Mockito.verify(viewState).renderCountryFlag(byteArray);
    }

    @Test
    public void actionAfterErrorResponse() {
        presenter.actionAfterErrorResponse(Mockito.anyString());
        Mockito.verify(viewState).showLoadErrorMessage(Mockito.anyString());
    }

}