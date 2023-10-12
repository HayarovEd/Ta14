package dengiruonlinenakartu.bezotkaza.ui

import dengiruonlinenakartu.bezotkaza.domain.model.Loan


data class MainState(
    val moneyList: List<Loan> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = true
)
