package com.alish.boilerplate.models

import com.alish.boilerplate.base.IBaseDiffModel

data class Foo(
    override val id: Long,
    val bar: String
) : IBaseDiffModel