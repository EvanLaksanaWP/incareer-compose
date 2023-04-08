package com.raion.incareer.presentation.home


import androidx.lifecycle.ViewModel
import com.raion.incareer.data.dummy.*

class HomeViewModel(): ViewModel() {
    fun getUserImage(): Int{
        return user.profilePicture
    }

    fun getUserName(): String{
        return user.username
    }

    fun getJobs(): List<Job> {
        return jobs
    }

    fun getCategories(): List<Category>{
        return categories
    }
}
