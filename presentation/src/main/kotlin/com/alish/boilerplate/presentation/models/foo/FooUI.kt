package com.alish.boilerplate.presentation.models.foo

import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.presentation.core.base.IBaseDiffModel

data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Foo.toUI() = FooUI(id, bar)