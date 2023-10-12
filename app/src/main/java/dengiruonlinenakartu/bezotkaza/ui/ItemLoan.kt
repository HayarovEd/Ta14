package dengiruonlinenakartu.bezotkaza.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dengiruonlinenakartu.bezotkaza.R
import dengiruonlinenakartu.bezotkaza.domain.model.Loan
import dengiruonlinenakartu.bezotkaza.ui.theme.blue
import dengiruonlinenakartu.bezotkaza.ui.theme.darkGrey
import dengiruonlinenakartu.bezotkaza.ui.theme.white
import dengiruonlinenakartu.bezotkaza.ui.theme.yellow

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan
) {
    val openLink = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(loan.url))
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = white)
            .padding(20.dp)
    ) {
        Row(
            modifier = modifier
                .padding(top = 8.dp)
                .align(alignment = Alignment.TopEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = loan.rang.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = blue
                )
            )
            Spacer(modifier = modifier.width(3.dp))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.star),
                tint = if (loan.isFavorite) yellow else blue,
                contentDescription = "star"
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
           AsyncImage(
                modifier = modifier
                    .width(170.dp),
                model = loan.imageUrl,
                contentScale = ContentScale.FillWidth,
                contentDescription = ""
            )
            Spacer(modifier = modifier.height(12.dp))
            Divider(
                modifier = modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = darkGrey
            )
            Spacer(modifier = modifier.height(12.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemData(
                    modifier.weight(1f),
                    icon = ImageVector.vectorResource(id = R.drawable.persent),
                    name = stringResource(id = R.string.bet),
                    content = loan.percent
                )
                Spacer(modifier = modifier.width(10.dp))
                ItemData(
                    modifier.weight(1f),
                    icon = ImageVector.vectorResource(id = R.drawable.people),
                    name = stringResource(id = R.string.age),
                    content = loan.age
                )
            }
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemData(
                    modifier.weight(1f),
                    icon = ImageVector.vectorResource(id = R.drawable.money),
                    name = stringResource(id = R.string.amount),
                    content = loan.sumOne
                )
                Spacer(modifier = modifier.width(10.dp))
                ItemData(
                    modifier.weight(1f),
                    icon = ImageVector.vectorResource(id = R.drawable.calendar),
                    name = stringResource(id = R.string.long_loan),
                    content = loan.daysInfo
                )
            }
            Spacer(modifier = modifier.height(12.dp))
            Divider(
                modifier = modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = darkGrey
            )
            Spacer(modifier = modifier.height(12.dp))
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = white
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(vertical = 9.dp),
                    onClick = { openLink.launch(intent) }) {
                    Text(
                        text = stringResource(id = R.string.more),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(400),
                            color = blue
                        )
                    )
                }
                Spacer(modifier = modifier.width(15.dp))
                Button(
                    modifier = modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = yellow
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(vertical = 9.dp),
                    onClick = { openLink.launch(intent) }) {
                    Text(
                        text = stringResource(id = R.string.request),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(900),
                            color = white
                        )
                    )
                }
            }
        }
    }

}

@Composable
fun ItemData(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    name: String,
    content: String
) {
    Box(
        modifier = modifier
        //.fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 35.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(400),
                    color = blue
                ),
                textAlign =  TextAlign.Start
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = content,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(900),
                    color = blue
                ),
                textAlign =  TextAlign.Start
            )
        }
        Icon(
            modifier = modifier.padding(top = 0.dp),
            imageVector = icon,
            tint = blue,
            contentDescription = ""
        )
    }
}
