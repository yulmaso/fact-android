package com.yulmaso.kskfact.data.model

import com.yulmaso.kskfact.data.model.enums.Role


class User {
    var id: Long? = null
    var authority: Role? = null
    var username: String? = null
    var password: String? = null

    var realname: String? = null
    var phone: Int? = null

    var enabled: Boolean? = null
    var accountNonExpired: Boolean? = null
    var accountNonLocked: Boolean? = null
    var credentialsNonExpired: Boolean? = null

    var positions: List<UserPosition>? = null
    var horses: List<Horse>? = null
    var events: List<Event>? = null
    var horseAccess: List<HorseAccess>? = null

    constructor(id: Long?, authority: Role?, username: String?, password: String?, enabled: Boolean?, accountNonExpired: Boolean?, accountNonLocked: Boolean?, credentialsNonExpired: Boolean?) {
        this.id = id
        this.authority = authority
        this.username = username
        this.password = password
        this.enabled = enabled
        this.accountNonExpired = accountNonExpired
        this.accountNonLocked = accountNonLocked
        this.credentialsNonExpired = credentialsNonExpired
    }

    constructor()

    data class builder(
            private var id: Long? = null,
            private var authority: Role? = null,
            private var username: String? = null,
            private var password: String? = null,

            private var enabled: Boolean? = null,
            private var accountNonExpired: Boolean? = null,
            private var accountNonLocked: Boolean? = null,
            private var credentialsNonExpired: Boolean? = null
    ) {
        fun id(id: Long) = apply { this.id = id }
        fun authority(authority: Role) = apply { this.authority = authority }
        fun username(username: String) = apply { this.username = username }
        fun password(password: String) = apply { this.password = password }

        fun enabled(enabled: Boolean) = apply { this.enabled = enabled }
        fun accountNonExpired(accountNonExpired: Boolean) = apply { this.accountNonExpired = accountNonExpired }
        fun accountNonLocked(accountNonLocked: Boolean) = apply { this.accountNonLocked = accountNonLocked }
        fun credentialsNonExpired(credentialsNonExpired: Boolean) = apply { this.credentialsNonExpired = credentialsNonExpired }

        fun build() = User(id, authority, username, password, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired)
    }
}