import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.take_note_kotlin_compose.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.take_note_kotlin_compose.ui.theme.ButtonBackground
import com.example.take_note_kotlin_compose.ui.theme.Gray100
import com.example.take_note_kotlin_compose.ui.theme.RedDelete



@Composable
fun NoteScreen( showSideBar: Boolean,
                onPressShowSideBar :()->Unit
    ){
    val calcPadding = LocalConfiguration.current.screenWidthDp.dp * .10f;
    val calcOfsset  = LocalConfiguration.current.screenWidthDp.dp * .64f;
    Surface(elevation = 4.dp,) {
        Column(
            modifier = Modifier
                .padding(vertical = calcPadding, horizontal = calcPadding)
                .fillMaxWidth()
                .offset(x = if (showSideBar) calcOfsset else 0.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopBar(showSideBar, onPressShowSideBar = onPressShowSideBar)
            NoteContent()
            Spacer(modifier = Modifier.weight(1f))
            BottomActions()
        }
    }
}

@Composable
fun TopBar(showSideBar: Boolean, onPressShowSideBar :()->Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()

        , horizontalArrangement = Arrangement.SpaceBetween

    ){
        HamNav(showSideBar,
            onPressShowSideBar=onPressShowSideBar,
            Modifier.background(MaterialTheme.colors.secondary))
        Text(text = "Sept 02, 2022",
            style = MaterialTheme.typography.caption,
            color= Gray100,
            fontSize = 16.sp)
    }
}



@Composable
fun NoteContent(){
    Column {
        Row(modifier = Modifier
            .padding(vertical = 32.dp)) {
            Text(text = "#" , style = MaterialTheme.typography.h4)
            Text(text = "Waiting", style = MaterialTheme.typography.h4)
        }
        Text(text = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",
            style = MaterialTheme.typography.body1
        )

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
            size(30.dp),
            contentDescription =description )
    }
}



@Composable
fun HamNav(showSideBar: Boolean,
           onPressShowSideBar :()->Unit,
           modifier: Modifier){
    Column(
        modifier= Modifier
            .height(28.dp)
            .width(36.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onPressShowSideBar() }

        ,

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        if(showSideBar)
            Image(painter = painterResource(id = R.drawable._544641784)
                ,colorFilter = ColorFilter.tint(color = MaterialTheme.colors.secondary),
                contentDescription ="close")
            else {
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
}

