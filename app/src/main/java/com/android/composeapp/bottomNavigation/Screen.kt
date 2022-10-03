package com.android.composeapp.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val title: String,
    val icon: ImageVector
) {

    object Home : Screen("home", "Home", Icons.Outlined.Home)
    object Search : Screen("search", "Search", Icons.Outlined.Search)
    object Contact : Screen("contact", "Contact", Icons.Outlined.Phone)
    object Profile : Screen("profile", "Profile", Icons.Outlined.Person)

    object Items {
        val list = listOf(
            Home, Search, Contact, Profile
        )
    }
}



