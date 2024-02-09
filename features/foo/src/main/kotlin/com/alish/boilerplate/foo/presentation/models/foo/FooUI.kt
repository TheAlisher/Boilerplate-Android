package com.alish.boilerplate.foo.presentation.models.foo

import com.alish.boilerplate.foo.domain.models.Foo
import com.alish.boilerplate.presentation.core.base.IBaseDiffModel

data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Foo.toUI() = FooUI(id, bar)