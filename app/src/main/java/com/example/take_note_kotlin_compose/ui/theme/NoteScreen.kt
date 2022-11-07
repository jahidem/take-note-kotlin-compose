import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.take_note_kotlin_compose.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.take_note_kotlin_compose.ui.theme.ButtonBackground
import com.example.take_note_kotlin_compose.ui.theme.Gray100
import com.example.take_note_kotlin_compose.ui.theme.RedDelete

@Composable
fun HamNav(modifier: Modifier){
    Column(
        modifier= Modifier
            .height(34.dp)
            .width(42.dp)
            .clip(MaterialTheme.shapes.large)
            .padding(4.dp)
            .clickable { }
        ,

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier
                .width(28.dp)
                .height(3.dp)
                .clip(MaterialTheme.shapes.medium)
                .then(modifier)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .clip(MaterialTheme.shapes.medium)
                .then(modifier)
        )
        Box(
            modifier = Modifier
                .width(18.dp)
                .height(3.dp)
                .clip(MaterialTheme.shapes.medium)
                .then(modifier)
        )
    }
}

@Composable
fun TopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()

        , horizontalArrangement = Arrangement.SpaceBetween

    ){
        HamNav(Modifier.background(MaterialTheme.colors.secondary))
        Text(text = "Sept 02, 2022",
            style = MaterialTheme.typography.caption,
            color= Gray100,
            fontSize = 16.sp)
    }
}


@Composable
fun BottomActions(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()) {
        Row(
            Modifier
                .width(190.dp)
            , horizontalArrangement = Arrangement.SpaceBetween){
            StyledButton(
                drawable_id = R.drawable.image_fill0_wght400_grad0_opsz48,
                iconColor = Color.White,
                backgroundColor = ButtonBackground,
                description = "Image"
            )
            StyledButton(
                drawable_id = R.drawable.edit_fill0_wght400_grad0_opsz48,
                iconColor = Color.White,
                backgroundColor = ButtonBackground,
                description = "Edit"
            )
            StyledButton(
                drawable_id = R.drawable.delete_fill0_wght400_grad0_opsz48,
                iconColor = RedDelete,
                backgroundColor = ButtonBackground,
                description = "delete"
            )
        }
    }
}

@Composable
fun NoteContent(){
    Column {
        Row(modifier = Modifier
            .padding(vertical = 20.dp)) {
            Text(text = "#" , style = MaterialTheme.typography.h4)
            Text(text = "Waiting", style = MaterialTheme.typography.h4)
        }
        Text(text = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",
            style = MaterialTheme.typography.body1
        )

    }


}

@Composable
fun StyledButton(
    drawable_id: Int,
    iconColor: Color,
    backgroundColor: Color,
    description: String
){
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(backgroundColor)
        .clickable { }
        .padding(10.dp)
    ) {
        Image(painter = painterResource(id = drawable_id)
            ,colorFilter = ColorFilter.tint(color = iconColor),
            modifier = Modifier.
            size(28.dp),
            contentDescription =description )
    }
}
//@Composable
//fun StyledButton(
//    modifier: Modifier = Modifier,
//    imageVector: ImageVector,
//    onClick: (isEnabled: Boolean) -> Unit = {},
//    enable: Boolean = true,
//    backgroundColor: Color,
//){
//    Button(
//        onClick = { onClick(enable) },
//        modifier = modifier
//            .fillMaxWidth()
//            .shadow(0.dp)
//            .noInteractionClickable(enabled = false) { onClick(enable) },
//        elevation = ButtonDefaults.elevation(
//            defaultElevation = 0.dp,
//            pressedElevation = 0.dp,
//            hoveredElevation = 0.dp,
//            focusedElevation = 0.dp
//        ),
//        shape = RoundedCornerShape(28.dp),
//        contentPadding = PaddingValues(15.dp),
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = backgroundColor,
//        ),
//        border = BorderStroke(1.dp, MaterialTheme.colors.getButtonBorderStroke)
//    ) {
//        Icon(
//            imageVector = imageVector,
//            modifier = Modifier
//                .size(18.dp),
//            contentDescription = "drawable_icons",
//            tint = Color.Unspecified
//        )
//    }
//}
