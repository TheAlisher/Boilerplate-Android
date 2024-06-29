package com.alish.boilerplate.foo.presentation.model

import com.alish.boilerplate.foo.domain.model.Foo
import com.alish.boilerplate.presentation.core.base.IBaseDiffModel

data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Foo.toUI() = FooUI(id, bar)