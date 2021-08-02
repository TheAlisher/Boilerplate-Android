package com.alish.boilerplate.models.paging

import com.alish.boilerplate.base.IBaseDiffModel

data class FooPagingData(
    override val id: Long,
    val bar: String
) : IBaseDiffModel