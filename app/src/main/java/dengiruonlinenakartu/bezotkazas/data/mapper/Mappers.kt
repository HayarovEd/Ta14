package dengiruonlinenakartu.bezotkazas.data.mapper

import dengiruonlinenakartu.bezotkazas.data.remote.LoanDto
import dengiruonlinenakartu.bezotkazas.domain.model.Loan
import kotlin.random.Random

fun List<LoanDto>.mapToLoan(): List<Loan> {
    return this.map {
        Loan(
            imageUrl = it.imageUrl,
            percent = it.percent,
            sumOne = it.sumOne,
            url = it.url,
            age = it.age,
            daysInfo = it.daysInfo,
            isFavorite = Random.nextBoolean(),
            rang = randomRang()
        )
    }
}

private fun randomRang(): Double {
    val randomInt = Random.nextInt(30,51)
    return randomInt.toDouble()/10
}