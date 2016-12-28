package com.orogersilva.kap.adapter;

import com.orogersilva.kap.domain.executor.Executor;
import com.orogersilva.kap.domain.executor.MainThread;

/**
 * Created by orogersilva on 12/28/2016.
 */

public abstract class AbstractPresenter {

    // region FIELDS

    protected Executor mExecutor;
    protected MainThread mMainThread;

    // endregion

    // region CONSTRUCTORS

    public AbstractPresenter(Executor executor, MainThread mainThread) {

        mExecutor = executor;
        mMainThread = mainThread;
    }

    // endregion
}
