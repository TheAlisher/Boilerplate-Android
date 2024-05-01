package com.alish.boilerplate.domain.repository

import com.alish.boilerplate.domain.core.RemoteWrapper
import com.alish.boilerplate.domain.model.Bar

interface BarRepository {

    fun fetchBar(): RemoteWrapper<Bar>
}