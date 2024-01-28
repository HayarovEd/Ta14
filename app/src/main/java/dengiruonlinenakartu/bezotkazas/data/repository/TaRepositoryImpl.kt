package dengiruonlinenakartu.bezotkazas.data.repository

import dengiruonlinenakartu.bezotkazas.data.mapper.mapToLoan
import dengiruonlinenakartu.bezotkazas.data.remote.ApiTa
import dengiruonlinenakartu.bezotkazas.domain.model.Loan
import dengiruonlinenakartu.bezotkazas.domain.repository.TaRepository
import dengiruonlinenakartu.bezotkazas.domain.utils.Resource
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