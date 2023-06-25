import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.utils.BottomNavItem

@Composable
fun BottomNavigationScreen(
    navController: NavHostController
) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Keys,
        BottomNavItem.Profile
    )
    BottomNavigation(
        modifier= Modifier
            .height(72.dp)
            .clip(
                shape= RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                )
            ),
        backgroundColor = ColorPrimary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.screenRoute,
                        tint= item.color
                    )

                },
                selected = currentRoute == item.screenRoute,
                onClick = { /*TODO*/ }
            )

        }
        
    }
   

}