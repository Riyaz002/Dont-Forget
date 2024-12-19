package com.wiseowl.notifier.data.local.repository

import com.wiseowl.notifier.data.local.FirebaseFireStore
import com.wiseowl.notifier.data.local.NotifierDataStore
import com.wiseowl.notifier.domain.repository.UserRepository
import com.wiseowl.notifier.domain.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl private constructor(): UserRepository {
    private val local = NotifierDataStore
    private val remote = FirebaseFireStore
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override suspend fun saveUser(user: User) {
        remote.saveUser(user)
        local.saveUser(user)
    }

    override fun getUser(): Flow<User> {
        return local.getUser()
    }

    override suspend fun getUserById(id: String): User {
        return scope.async { remote.getUserById(id) }.await()
    }

    override suspend fun updateUser(user: User) {
        remote.updateUser(user)
        local.updateUser(user)
    }

    companion object{
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            return INSTANCE ?: synchronized(this){
                INSTANCE = UserRepositoryImpl()
                return INSTANCE!!
            }
        }
    }
}