package dengiruonlinenakartu.bezotkazas.data.remote

import retrofit2.http.GET

interface ApiTa {
    @GET("alexofyou/derst/main/db.json")
    suspend fun getData() : List<LoanDto>
}