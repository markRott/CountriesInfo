package com.example;

import io.reactivex.Scheduler;

/**
 * Created by sma on 10.10.17.
 */

public interface IPostExecutionThread {


    Scheduler getScheduler();

}
