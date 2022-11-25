package com.rgp.mvvmandroidexample.model.repository

import com.rgp.mvvmandroidexample.model.entities.User

class UserRepository {
    companion object {
        fun getFakeUsers() : ArrayList<User> {
            val list = arrayListOf<User>()

            list.add(User("JUAN", "PÉREZ", 23, "https://c4.wallpaperflare.com/wallpaper/814/865/162/starcraft-ii-nova-nova-terra-heroes-of-the-storm-wallpaper-preview.jpg"))
            list.add(User("JOSÉ", "PÉREZ", 23, "https://c4.wallpaperflare.com/wallpaper/814/865/162/starcraft-ii-nova-nova-terra-heroes-of-the-storm-wallpaper-preview.jpg"))
            list.add(User("MARIO", "PÉREZ", 23, "https://c4.wallpaperflare.com/wallpaper/814/865/162/starcraft-ii-nova-nova-terra-heroes-of-the-storm-wallpaper-preview.jpg"))
            list.add(User("ANASTASIO", "PÉREZ", 23, "https://c4.wallpaperflare.com/wallpaper/814/865/162/starcraft-ii-nova-nova-terra-heroes-of-the-storm-wallpaper-preview.jpg"))
            list.add(User("LEO", "PÉREZ", 23, "https://c4.wallpaperflare.com/wallpaper/814/865/162/starcraft-ii-nova-nova-terra-heroes-of-the-storm-wallpaper-preview.jpg"))

            return list
        }
    }
}