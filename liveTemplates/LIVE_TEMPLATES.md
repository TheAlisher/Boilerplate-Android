# Live templates

#### Abbreviation: UseCase | Description: Create UseCase

- `$Request$` - expression: `camelCase(UseCaseName)`

```kotlin
import javax.inject.Inject

class $UseCaseName$UseCase @Inject constructor(
    private val repository: $RepositoryName$
) {
    operator fun invoke() = repository.$Request$()
}
```

---

##### Abbreviation: request | Description: Create request with UseCase and UIStates

```kotlin
private val _$StateName$State = MutableUIStateFlow<$ModelName$>()
val $StateName$State = _$StateName$State.asStateFlow()

fun $UseCaseName$() {
    $UseCaseName$UseCase().collectRequest(_$StateName$State) { it.toUI() }
}
```

---

##### Abbreviation: subscribeTo | Description: Subscribe to UIState

- `$UIState$` - expression: `camelCase(UIStateName)`

```kotlin
private fun subscribeTo$UIStateName$() = with(binding) {
    viewModel.$UIState$State.collectUIState(
        state = {
            it.setupViewVisibility()
         },
        onError = {
            it.setupApiErrors()
         },
         onSuccess = {
             $END$
         }
    )
}
```

---

##### Abbreviation: recycler | Description: Setup RecyclerView with Adapter

- `$AdapterName$` - expression: `camelCase(RecyclerName)`

```kotlin
private val $RecyclerName$Adapter = $AdapterName$Adapter()

private fun setup$AdapterName$Recycler() = with(binding.recycler$RecyclerView$) {
    layoutManager = LinearLayoutManager(context)
    adapter = $RecyclerName$Adapter
}
```
