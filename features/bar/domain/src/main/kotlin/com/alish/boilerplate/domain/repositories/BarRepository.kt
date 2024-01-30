package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.core.RemoteWrapper
import com.alish.boilerplate.domain.models.Bar

interface BarRepository {

    fun fetchBar(): RemoteWrapper<Bar>
}