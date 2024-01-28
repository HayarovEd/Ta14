package dengiruonlinenakartu.bezotkazas.ui

import dengiruonlinenakartu.bezotkazas.domain.model.Loan


data class MainState(
    val moneyList: List<Loan> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = true
)
