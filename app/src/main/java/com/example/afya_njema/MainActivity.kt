package com.example.afya_njema

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.afya_njema.screens.WelcomeScreen
import com.example.afya_njema.screens.displayInfo
import com.example.afya_njema.ui.theme.Afya_njemaTheme
import com.google.accompanist.pager.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.launch

lateinit var navController : NavHostController

var valeur = ""
var numbers= mutableListOf<String>("1", "2", "3", "4", "5", "6")

var categories = mutableListOf<String>("Catégorie 1", "Catégorie 2", "Catégorie 3")
var categories2 : List<String> = listOf("Catégorie 5", "Catégorie 7", "Catégorie 8")

var clickedItemContent ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse rutrum urna vel odio rhoncus vehicula" +
        "" +
        ". Vivamus quam turpis, blandit vel tristique in, suscipit ac orci. Sed vel libero et augue scelerisque pulvinar vel a ipsum. Fusce nulla dolor, iaculis in sem vel, vestibulum tincidunt massa. Sed id odio at est faucibus egestas eu nec sapien." +
        "" +
        " Proin vel laoreet nibh. Suspendisse neque tortor, viverra ac suscipit non, euismod vel enim. Praesent vitae hendrerit tortor. Nulla tincidunt lobortis tortor, at lobortis sapien varius nec. Nunc venenatis leo eu mauris dapibus iaculis. Nam a porttitor ex. Sed euismod, velit vel ultrices aliquet, odio quam laoreet libero, sit amet tincidunt sapien massa quis tortor. Etiam ornare est ac ante tincidunt semper."

var clickedItemImageUrl="https://firebasestorage.googleapis.com/v0/b/make-it-so-app-73465.appspot.com/o/Capture.PNG?alt=media&token=96ab7b68-b02e-4583-a9f8-f49317613542"
var clickedItemTitle = "Text Header"
var clickedItemSoundURL = "https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/sounds%2FNouvel%20enregistrement%2013.m4a?alt=media&token=24c12bb4-38d6-498e-a4c4-f4c5fdd84856"

val contentMalaria = "The first symptoms of malaria usually begin within 10–15 days after the bite from an infected mosquito. Fever, headache and chills are typically experienced, though these symptoms may be mild and difficult to recognize as malaria. In malaria endemic areas, people who have developed partial immunity may become infected but experience no symptoms (asymptomatic infections)."

var itemCategoryList = mutableListOf<String>("DEATHS UNDER 5 YEARS OF AGE","MATERNAL MORTALITY","COMMUNICABLE DISEASES","PROMOTE MENTAL HEALTH","SUBSTANCE ABUSE")
var itemTitleList = mutableListOf<String>("Malaria","Pregnancy accompaniment","measles","Depression")
var itemContentList = mutableListOf<String>(clickedItemContent,clickedItemContent,clickedItemContent,clickedItemContent,clickedItemContent)
var itemImageURLList = mutableListOf<String>("https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/images%2F5years.PNG?alt=media&token=3ebd708f-9656-4348-8082-37cfd4e12f4a","https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/images%2Fcommunicable.PNG?alt=media&token=73afdda4-c947-4637-a3d3-3ee8c777288f","https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/images%2Ffamily_planning.PNG?alt=media&token=09489cdf-399d-4a4c-9b3c-a11d57df7412","https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/images%2Fmaternal_mortality.PNG?alt=media&token=7452e741-6c7f-46f4-8ac5-344c608debac","https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/images%2Freproductive.PNG?alt=media&token=524732c2-83ab-4694-963b-d367ab8b359a")
var itemSoundURLList = mutableListOf<String>("https://firebasestorage.googleapis.com/v0/b/yabiso-8ce15.appspot.com/o/sounds%2FNouvel%20enregistrement%2013.m4a?alt=media&token=24c12bb4-38d6-498e-a4c4-f4c5fdd84856")



class MainActivity : ComponentActivity() {



    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Afya_njemaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)


                }

            }
        }
        var database= FirebaseDatabase.getInstance().reference

        //database.child(numero.toString()).setValue(Personne(nom,numero))

        //obtenir les donnees
        var getdata= object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb=StringBuilder()
                for (i in p0.children){
                    var itemCategory = i.child("category").getValue()
                    var itemTitle = i.child("title").getValue()
                    var itemContent = i.child("content").getValue()
                    var itemImageURL = i.child("imageURL").getValue()
                    var itemSoundURL = i.child("soundURL").getValue()

                    itemCategoryList.add(itemCategory.toString())
                    itemTitleList.add(itemTitle.toString())
                    itemContentList.add(itemContent.toString())
                    itemImageURLList.add(itemImageURL.toString())
                    itemSoundURLList.add(itemSoundURL.toString())


                    //sb.append("${i.key} $name $num\n")
                }

            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
        numbers = itemTitleList
        categories = itemCategoryList
    }

}

@Composable
fun Greeting() {
    Text(text = valeur)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Afya_njemaTheme {
        Greeting()
    }
}

//***********************************************************************************************************

/*@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalPagerApi
@Composable
fun mainScreen(navController: NavController){
    val tabs = listOf(
      //  TabItem.Home,
        //TabItem.Second,

        )
    val pagerState = rememberPagerState(pageCount = tabs.size)

    Scaffold(topBar = { TopBar() }) {
        Column() {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }

    }
}

@Composable
fun TopBar(){
    TopAppBar(
        title = { Text("My Application")},
        backgroundColor = Color.Green,
        contentColor = Color.Black

    )

}

@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState){
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Green,
        contentColor = Color.Black,
        indicator = {tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )

        }
    ) {
        tabs.forEachIndexed { index, tab ->
            LeadingIconTab(
                icon ={ Icon(painter= painterResource(id = tab.icon), contentDescription = "") },
                text = { Text(text = tab.title)},
                selected = pagerState.currentPage ==index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
        }

    }

}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs:List<TabItem>, pagerState: PagerState){
    HorizontalPager(state = pagerState) {page ->
        tabs[page].screen()

    }
}
*/