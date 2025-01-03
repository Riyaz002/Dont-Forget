package com.wiseowl.notifier.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Screen

@Serializable
data object Login: Screen
@Serializable
data object Registration: Screen
@Serializable
data object Home: Screen
@Serializable
data object AddRule: Screen