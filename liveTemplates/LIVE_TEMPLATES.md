# Live templates

##### UseCase

```kotlin
import javax.inject.Inject

class $UseCaseName$UseCase @Inject constructor(
    private val repository : $RepositoryName$
) {
    operator fun invoke() = repository.$RequestName$()
}
```

https://user-images.githubusercontent.com/60399817/202648757-5161cebd-cafb-42e8-80d3-50bea1ed96c9.mov

##### Request in ViewModel with UseCase and UIState

```kotlin
private val _$StateName$State = MutableUIStateFlow<$ModelName$>()
val $StateName$State = _$StateName$State.asStateFlow()

fun $UseCaseName$() {
    $UseCaseName$UseCase().collectRequest(_$StateName$State) { it.toUI() }
}
```

https://user-images.githubusercontent.com/60399817/202648959-e7431a78-1831-41f6-bb1f-90397b31f575.mov

##### Collect UIState in Fragment

```kotlin
private fun subscribeTo$UIStateName$() = with(binding) {
    viewModel.$UIState$.collectUIState(
    state = {
        it.setupViewVisibility()
    },
    onError = {
        it.setupApiErrors()
    },
    onSuccess = {
    }
    )
}
```

https://user-images.githubusercontent.com/60399817/202649190-3957321d-9702-4529-a02a-e7d2265e2c3f.mov
