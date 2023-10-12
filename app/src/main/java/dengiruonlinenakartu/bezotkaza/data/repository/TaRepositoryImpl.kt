package dengiruonlinenakartu.bezotkaza.data.repository

import dengiruonlinenakartu.bezotkaza.data.mapper.mapToLoan
import dengiruonlinenakartu.bezotkaza.data.remote.ApiTa
import dengiruonlinenakartu.bezotkaza.domain.model.Loan
import dengiruonlinenakartu.bezotkaza.domain.repository.TaRepository
import dengiruonlinenakartu.bezotkaza.domain.utils.Resource
import javax.inject.Inject

class TaRepositoryImpl @Inject constructor(private val apiTa: ApiTa) : TaRepository {
    override suspend fun getRemoteData(): Resource<List<Loan>> {
        return try {
            val result = apiTa.getData()
            Resource.Success(
                result.mapToLoan()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }
}