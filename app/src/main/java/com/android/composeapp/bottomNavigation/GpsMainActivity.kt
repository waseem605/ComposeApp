package com.android.composeapp.bottomNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.composeapp.R
import com.android.composeapp.ui.theme.ComposeAppTheme

class GpsMainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                    ) {
                        CustomDrawer()
                        Spacer(modifier = Modifier.height(10.dp))
                        TopListViewItems(topItemList())
                        Spacer(modifier = Modifier.height(10.dp))
                        CenterLayout()

                        Spacer(modifier = Modifier.height(10.dp))
                        BottomListViewItems(bottomItemList())
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            CustomDrawer()
            Spacer(modifier = Modifier.height(10.dp))
            TopListViewItems(topItemList())
            Spacer(modifier = Modifier.height(10.dp))
            CenterLayout()

            Spacer(modifier = Modifier.height(10.dp))
            BottomListViewItems(bottomItemList())
        }
    }
}

@Composable
fun CenterLayout() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Card(modifier = Modifier
                .width(220.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 2.dp,
                backgroundColor = Color.Gray
            ) {
                Image(painter = painterResource(id = R.drawable.home_top_image),
                    contentDescription = "stImage",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier
                .requiredWidth(110.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 2.dp,
                backgroundColor = Color.Gray
            ) {
                Image(painter = painterResource(id = R.drawable.street_view1),
                    contentDescription = "stImage",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Spacer(modifier = Modifier.width(12.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(200.dp)
            .padding(0.dp, 0.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(modifier = Modifier
                .requiredWidth(110.dp)
                .requiredHeight(180.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 2.dp,
                backgroundColor = Color.Gray
            ) {
                Image(painter = painterResource(id = R.drawable.gps_nav),
                    contentDescription = "stImage",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier
                .fillMaxHeight()
                .requiredHeight(180.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier
                    .requiredWidth(110.dp)
                    .requiredHeight(85.dp)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.Gray
                ) {
                    Image(painter = painterResource(id = R.drawable.earth_view),
                        contentDescription = "stImage",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Card(modifier = Modifier
                    .requiredWidth(110.dp)
                    .requiredHeight(85.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.Gray
                ) {
                    Image(painter = painterResource(id = R.drawable.e_book),
                        contentDescription = "stImage",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier
                .fillMaxHeight()
                .requiredHeight(180.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier
                    .requiredWidth(110.dp)
                    .requiredHeight(85.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.Gray
                ) {
                    Image(painter = painterResource(id = R.drawable.my_location),
                        contentDescription = "stImage",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(modifier = Modifier
                    .requiredWidth(110.dp)
                    .requiredHeight(85.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.Gray
                ) {
                    Image(painter = painterResource(id = R.drawable.custom_icon),
                        contentDescription = "stImage",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }


    }
}

@Composable
fun CustomDrawer() {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {

        Spacer(modifier = Modifier
            .height(10.dp)
            .background(color = Color.White))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(painter = painterResource(id = R.drawable.drewer),
                contentDescription = "Drawer",
                modifier = Modifier
                    .width(55.dp)
                    .height(45.dp)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Satellite Map & Street View",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
                Text(
                    text = "GPS Navigation",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalMaterialApi
@Composable
fun TopListViewItems(data: ArrayList<TopGpsModel>) {
//    LazyVerticalGrid(columns = GridCells.Fixed(5),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)) {
//        items(data){item: TopGpsModel ->
//            EachCardItem(item)
//        }
//
//    }
}

@ExperimentalMaterialApi
@Composable
fun BottomListViewItems(data: ArrayList<TopGpsModel>) {
/*    LazyVerticalGrid(columns = GridCells.Fixed(5),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        items(data) { model ->
            EachBottomCardItem(model)
        }
    }*/
}


@ExperimentalMaterialApi
@Composable
fun EachCardItem(model: TopGpsModel) {
    Card(
        onClick = {
            // inside on click we are displaying the toast message.
            /*   Toast.makeText(
                   context,
                   model.title,
                   Toast.LENGTH_SHORT
               ).show()*/
        },
        modifier = Modifier.padding(4.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(CornerSize(12.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = model.icon),
                contentDescription = "image",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .fillMaxSize()
            )
            Text(text = model.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textAlign = TextAlign.Center,
                color = Color.Black,
                maxLines = 3,
                fontSize = 12.sp)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun EachBottomCardItem(model: TopGpsModel) {
    Card(
        onClick = {
            // inside on click we are displaying the toast message.
            /*   Toast.makeText(
                   context,
                   model.title,
                   Toast.LENGTH_SHORT
               ).show()*/
        },
        modifier = Modifier.padding(4.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(CornerSize(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(painter = painterResource(id = model.icon),
                contentDescription = "image",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .fillMaxSize()
            )
            Text(text = model.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textAlign = TextAlign.Center,
                color = Color.Black,
                maxLines = 3,
                fontSize = 12.sp)
        }
    }
}





/*Surface(color = MaterialTheme.colors.background) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        CustomDrawer()
        Spacer(modifier = Modifier.height(10.dp))
        TopListViewItems(topItemList())
        Spacer(modifier = Modifier.height(10.dp))
        CenterLayout()

        Spacer(modifier = Modifier.height(10.dp))
        BottomListViewItems(bottomItemList())
    }

}*/


//   model data

data class TopGpsModel(
    val icon:Int,
    val title:String
)


fun topItemList():ArrayList<TopGpsModel>{
    val mList = ArrayList<TopGpsModel>()
    mList.add(TopGpsModel(R.drawable.weather,"Weather\n "))
    mList.add(TopGpsModel(R.drawable.icon_gps_cam,"GPS\nCamera"))
    mList.add(TopGpsModel(R.drawable.icon_route_finder,"Route\nFinder"))
    mList.add(TopGpsModel(R.drawable.icon_speed_cam,"Speed\nCamera"))
    mList.add(TopGpsModel(R.drawable.web_cam,"Web\nCamera"))
    return mList
}

fun bottomItemList():ArrayList<TopGpsModel>{
    val mList = ArrayList<TopGpsModel>()
    mList.add(TopGpsModel(R.drawable.weather,"Weather\n "))
    mList.add(TopGpsModel(R.drawable.icon_gps_cam,"GPS\nCamera"))
    mList.add(TopGpsModel(R.drawable.icon_route_finder,"Route\nFinder"))
    mList.add(TopGpsModel(R.drawable.icon_speed_cam,"Speed\nCamera"))
    mList.add(TopGpsModel(R.drawable.web_cam,"Web\nCamera"))
    return mList
}