package com.example.sampledatastore.platform.di.module

import com.example.sampledatastore.data.repository.PreferenceDataStoreRepositoryImpl
import com.example.sampledatastore.data.repository.PreferenceSharedRepositoryImp
import com.example.sampledatastore.domain.usecase.PreferenceDataStoreUseCase
import com.example.sampledatastore.domain.usecase.PreferenceSharedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun preferenceSharedUseCaseProvider(preferenceSharedRepositoryImpl: PreferenceSharedRepositoryImp) =
        PreferenceSharedUseCase(preferenceSharedRepositoryImpl)

    @Provides
    fun preferenceDataStoreUseCaseProvider(preferenceDataStoreRepositoryImpl: PreferenceDataStoreRepositoryImpl) =
        PreferenceDataStoreUseCase(preferenceDataStoreRepositoryImpl)

}
