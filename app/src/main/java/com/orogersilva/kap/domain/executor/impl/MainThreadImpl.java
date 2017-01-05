package com.orogersilva.kap.domain.executor.impl;

import android.os.Handler;

import com.orogersilva.kap.domain.executor.MainThread;

/**
 * Created by orogersilva on 12/28/2016.
 */

public class MainThreadImpl implements MainThread {

    // region FIELDS

    private Handler mHandler;

    // endregion

    // region CONSTRUCTORS

    public MainThreadImpl(Handler handler) {

        mHandler = handler;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void post(Runnable runnable) {

        mHandler.post(runnable);
    }

    // endregion
}
