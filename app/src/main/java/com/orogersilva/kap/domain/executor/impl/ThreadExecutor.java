package com.orogersilva.kap.domain.executor.impl;

import com.orogersilva.kap.domain.executor.Executor;
import com.orogersilva.kap.domain.usecase.base.AbstractUseCase;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by orogersilva on 12/28/2016.
 */

public class ThreadExecutor implements Executor {

    // region FIELDS

    private static Executor INSTANCE;

    private ThreadPoolExecutor mThreadPoolExecutor;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingDeque<Runnable> WORK_QUEUE = new LinkedBlockingDeque<>();

    // endregion

    // region CONSTRUCTORS

    private ThreadExecutor() {

        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    // endregion

    // region STATIC METHODS

    public static Executor getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new ThreadExecutor();
        }

        return INSTANCE;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void execute(final AbstractUseCase useCase) {

        mThreadPoolExecutor.submit(new Runnable() {

            @Override
            public void run() {

                useCase.run();
            }
        });
    }

    // endregion
}
