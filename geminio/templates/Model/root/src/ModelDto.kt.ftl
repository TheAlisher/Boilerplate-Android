package ${packageName}

import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.models.${modelPackage}.${modelPrefix}
import com.google.gson.annotations.SerializedName

class ${modelDto}() : DataMapper<${modelPrefix}> {

    override fun mapToDomain() = ${modelPrefix}()
}