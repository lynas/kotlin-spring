package com.lynas.service.implementation

import com.lynas.model.AppUser
import com.lynas.service.AppUserService
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by LynAs on 15-Jun-16.
 */

@Service("appUserService")
open class AppUserServiceImplj @Autowired constructor(val sessionFactory: SessionFactory) : AppUserService {

    @Transactional
    override fun add(appUser: AppUser) {
        sessionFactory.currentSession.save(appUser)
    }
}
