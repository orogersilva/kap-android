package com.orogersilva.kap.domain.executor;

import com.orogersilva.kap.domain.usecase.base.AbstractUseCase;

/**
 * Created by orogersilva on 12/28/2016.
 */

public interface Executor {

    // region METHODS

    void execute(final AbstractUseCase useCase);

    // endregion
}
