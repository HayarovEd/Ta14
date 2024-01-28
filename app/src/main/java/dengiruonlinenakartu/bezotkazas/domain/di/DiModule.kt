package dengiruonlinenakartu.bezotkazas.domain.di

import dengiruonlinenakartu.bezotkazas.data.repository.TaRepositoryImpl
import dengiruonlinenakartu.bezotkazas.domain.repository.TaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {
    @Binds
    @Singleton
    abstract fun bindRepository(taRepository: TaRepositoryImpl): TaRepository
}