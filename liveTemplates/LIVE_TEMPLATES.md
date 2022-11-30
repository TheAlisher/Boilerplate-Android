# Live templates

#### Abbreviation: UseCase | Description: Create UseCase

- `$Request$` - expression: `camelCase($UseCaseName$)`

```kotlin
import javax.inject.Inject

class $UseCaseName$UseCase @Inject constructor(
    private val repository: $RepositoryName$
) {
    operator fun invoke() = repository.$Request$()
}
```

___

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

##### Setup RecyclerView with Adapter

```kotlin
private val $ADAPTER_NAME$ = $ADAPTER_INSTANCE$()

private fun setup$RECYCLER_NAME$Recycler() = with(binding.recycler$RECYCLER_VIEW$) {
    layoutManager = LinearLayoutManager(context)
    adapter = $ADAPTER_NAME$
}
```
