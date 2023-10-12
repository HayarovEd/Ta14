package dengiruonlinenakartu.bezotkaza.domain.di

import dengiruonlinenakartu.bezotkaza.data.repository.TaRepositoryImpl
import dengiruonlinenakartu.bezotkaza.domain.repository.TaRepository
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