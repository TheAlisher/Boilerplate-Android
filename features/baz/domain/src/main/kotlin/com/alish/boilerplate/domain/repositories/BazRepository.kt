package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.core.RemoteWrapper
import com.alish.boilerplate.domain.models.Baz

interface BazRepository {

    fun fetchBaz(): RemoteWrapper<Baz>
}