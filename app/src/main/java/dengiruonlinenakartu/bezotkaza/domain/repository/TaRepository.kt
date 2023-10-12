package dengiruonlinenakartu.bezotkaza.domain.repository

import dengiruonlinenakartu.bezotkaza.domain.model.Loan
import dengiruonlinenakartu.bezotkaza.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}