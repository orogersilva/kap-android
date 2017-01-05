package com.orogersilva.kap.injection.module;

import android.os.Handler;

import com.orogersilva.kap.domain.executor.Executor;
import com.orogersilva.kap.domain.executor.MainThread;
import com.orogersilva.kap.domain.executor.impl.MainThreadImpl;
import com.orogersilva.kap.domain.executor.impl.ThreadExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by orogersilva on 12/28/2016.
 */

@Module
public class ThreadModule {

    // region PROVIDERS

    @Singleton
    @Provides public Executor provideExecutor() {

        final int CORE_POOL_SIZE = 3;
        final int MAX_POOL_SIZE = 5;
        final int KEEP_ALIVE_TIME = 120;
        final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
        final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

        ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);

        return new ThreadExecutor(mThreadPoolExecutor);
    }

    @Singleton
    @Provides public MainThread provideMainThread() {

        Handler handler = new Handler();

        return new MainThreadImpl(handler);
    }

    // endregion
}
