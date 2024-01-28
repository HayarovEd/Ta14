package dengiruonlinenakartu.bezotkazas.domain.repository

import dengiruonlinenakartu.bezotkazas.domain.model.Loan
import dengiruonlinenakartu.bezotkazas.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}