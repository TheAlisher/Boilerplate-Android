package com.alish.boilerplate.bar.domain.repository

import com.alish.boilerplate.domain.core.RemoteWrapper
import com.alish.boilerplate.bar.domain.model.Bar

interface BarRepository {

    fun fetchBar(): RemoteWrapper<Bar>
}