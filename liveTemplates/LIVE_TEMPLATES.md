# Live templates

##### Request in ViewModel with UseCase and UIState

```kotlin
private val _$StateName$State = MutableUIStateFlow<$ModelName$>()
val $StateName$State = _$StateName$State.asStateFlow()

fun $UseCaseName$() {
    $UseCaseName$UseCase().collectRequest(_$StateName$State) { it.toUI() }
}
```

##### Collect UIState in Fragment

```kotlin
viewModel.$StateName$.collectUIState(
    state = {
        it.setupViewVisibility()
    },
    onError = {
        it.setupApiErrors()
    },
    onSuccess = {
    }
)
```

##### UseCase

```kotlin
import javax.inject.Inject

class $UseCaseName$UseCase @Inject constructor(
    private val repository : $RepositoryName$
) {
    operator fun invoke() = repository.$RequestName$()
}
```