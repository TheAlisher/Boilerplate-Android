package ${packageName}

import com.alish.boilerplate.data.base.BasePagingSource
import com.alish.boilerplate.data.remote.apiservices.${pagingSourceApiService}
import com.alish.boilerplate.data.remote.dtos.${pagingSourcePackage}.${pagingSourcePrefix}Dto
import com.alish.boilerplate.domain.models.${pagingSourcePackage}.${pagingSourcePrefix}

class ${pagingSourceName}(
    private val service: ${pagingSourceApiService}
) : BasePagingSource<${pagingSourcePrefix}Dto, ${pagingSourcePrefix}>(
    { service. }
)