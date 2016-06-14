package com.lynas.service

import com.lynas.model.AppUser

interface AppUserService{
    open fun add(appUser: AppUser)
}