package com.orogersilva.kap.domain.executor;

/**
 * Created by orogersilva on 12/28/2016.
 */

public interface MainThread {

    // region METHODS

    void post(final Runnable runnable);

    // endregion
}
