package com.alish.boilerplate.common.base

interface IBaseDiffModel<N : Number> {
    val id: N
    override fun equals(other: Any?): Boolean
}