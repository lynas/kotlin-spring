package com.lynas.model

import javax.persistence.*

@Entity
data class AppUser(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @Column(unique = true, nullable = false) val userName: String,
        @Column(nullable = false) val password: String,
        @Column(nullable = false) val roles: String)