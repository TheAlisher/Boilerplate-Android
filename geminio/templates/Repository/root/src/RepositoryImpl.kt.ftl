package ${packageName}

import com.alish.boilerplate.data.base.BaseRepository
import com.alish.boilerplate.domain.repositories.${repositoryName}
import javax.inject.Inject

class ${repositoryNameImpl} @Inject constructor(
    private val service: ${repositoryApiService}
) : BaseRepository(), ${repositoryName} {
}