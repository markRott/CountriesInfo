package com.example.usecases;

import com.example.interfaces.ICountryRepository;
import com.example.interfaces.IPostExecutionThread;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Created by sma on 19.10.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class CountriesUseCaseTest {

    @Mock
    ICountryRepository repository;
    @Mock
    IPostExecutionThread mainThread;
//    @Mock
    CountriesUseCase useCase;

    @Before
    public void setUp() throws Exception {
        useCase = new CountriesUseCase(mainThread, repository);
        System.out.println("mainThread = " + mainThread);
        System.out.println("repository = " + repository);
        System.out.println("useCase = " + useCase);
    }

    @Test
    public void testA() throws Exception {
        useCase.buildUseCaseObservable(null);
        Mockito.verify(repository, Mockito.times(1)).getCountries();
    }

}