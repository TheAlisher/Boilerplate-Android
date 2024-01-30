package com.alish.boilerplate.presentation.models

import com.alish.boilerplate.domain.models.Bar
import com.alish.boilerplate.presentation.core.base.IBaseDiffModel

data class BarUI(
    override val id: Long,
    val name: String,
) : IBaseDiffModel<Long>

fun Bar.toUI() = BarUI(id, name)