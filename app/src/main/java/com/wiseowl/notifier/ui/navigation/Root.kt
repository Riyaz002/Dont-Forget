package com.wiseowl.notifier.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.wiseowl.notifier.ui.home.HomeScreen
import com.wiseowl.notifier.ui.login.LoginScreen

@Composable
fun Root(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Screen,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Home> { HomeScreen(modifier) }
        composable<Login> { LoginScreen(modifier) }
    }
}