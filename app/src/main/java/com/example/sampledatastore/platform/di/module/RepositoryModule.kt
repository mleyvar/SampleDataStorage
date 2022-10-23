package com.example.sampledatastore.platform.di.module

import com.example.sampledatastore.core.logger.Logger
import com.example.sampledatastore.data.repository.PreferenceDataStoreRepositoryImpl
import com.example.sampledatastore.data.repository.PreferenceSharedRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun logger(): Logger {
        return Logger()
    }

    @Provides
    fun PreferenceSharedRepositoryProvider(): PreferenceSharedRepositoryImp = PreferenceSharedRepositoryImp()

    @Provides
    fun PreferenceDataStoreRepositoryProvider(): PreferenceDataStoreRepositoryImpl = PreferenceDataStoreRepositoryImpl()


}