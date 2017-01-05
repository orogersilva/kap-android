package com.orogersilva.kap.domain.usecase.base;

import com.orogersilva.kap.domain.executor.Executor;
import com.orogersilva.kap.domain.executor.MainThread;

/**
 * Created by orogersilva on 12/28/2016.
 */

public abstract class AbstractUseCase implements UseCase {

    // region FIELDS

    protected final Executor mThreadExecutor;
    protected final MainThread mMainThread;

    // endregion

    // region CONSTRUCTORS

    public AbstractUseCase(Executor threadExecutor, MainThread mainThread) {

        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    // endregion

    // region ABSTRACT METHODS

    public abstract void run();

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void execute() {

        mThreadExecutor.execute(this);
    }

    // endregion
}
