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

    private ThreadPoolExecutor mThreadPoolExecutor;

    // endregion

    // region CONSTRUCTORS

    public ThreadExecutor(ThreadPoolExecutor threadPoolExecutor) {

        mThreadPoolExecutor = threadPoolExecutor;
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
