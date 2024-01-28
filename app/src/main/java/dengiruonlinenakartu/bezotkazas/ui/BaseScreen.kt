package dengiruonlinenakartu.bezotkazas.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dengiruonlinenakartu.bezotkazas.R
import dengiruonlinenakartu.bezotkazas.ui.theme.blue
import dengiruonlinenakartu.bezotkazas.ui.theme.grey

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val context = LocalContext.current
    if (state.value.error!=null) {
        Toast.makeText(context, state.value.error, Toast.LENGTH_LONG).show()
    }

    if (state.value.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = grey)
        ) {
            CircularProgressIndicator(
                modifier = modifier
                    .align(alignment = Alignment.Center)
                    .size(100.dp),
                color = blue
            )
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = grey)
        ) {
            Icon(
                modifier = modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(top = 20.dp, end = 25.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ring),
                tint = blue,
                contentDescription = "star"
            )
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    color = blue,
                    text = stringResource(id = R.string.loans),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(900)
                )
                Spacer(modifier = modifier.height(30.dp))
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(state.value.moneyList) { loan ->
                        ItemLoan(loan = loan)
                    }
                }
            }
        }

    }
}