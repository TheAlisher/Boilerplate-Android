### Module Graph

```mermaid
%%{
  init: {
    'theme': 'dark'
  }
}%%

graph LR
  subgraph :core
    :core:data["data"]
    :core:domain["domain"]
    :core:presentation["presentation"]
  end
  subgraph :feature
    :feature:foo["foo"]
    :feature:bar["bar"]
  end
  :core:data --> :core:domain
  :core:presentation --> :core:domain
  :db --> :core:data
  :db --> :feature:foo
  :db --> :feature:bar
  :feature:bar --> :core:data
  :feature:bar --> :core:domain
  :feature:bar --> :core:presentation
  :app --> :core:data
  :app --> :core:presentation
  :app --> :db
  :app --> :feature:foo
  :app --> :feature:bar
  :feature:foo --> :core:data
  :feature:foo --> :core:domain
  :feature:foo --> :core:presentation

classDef android-library fill:#3BD482,stroke:#fff,stroke-width:2px,color:#fff;
classDef kotlin-jvm fill:#8150FF,stroke:#fff,stroke-width:2px,color:#fff;
classDef android-application fill:#2C4162,stroke:#fff,stroke-width:2px,color:#fff;
class :core:data android-library
class :core:domain kotlin-jvm
class :core:presentation android-library
class :db android-library
class :feature:foo android-library
class :feature:bar android-library
class :app android-application

```

- - -

Created by [iurysza/module-graph](https://github.com/iurysza/module-graph)

Configs:
```kotlin
moduleGraphConfig {
    readmePath.set("./GRAPH.md")
    heading = "### Module Graph"
    setStyleByModuleType.set(true)
    rootModulesRegex.set(".*app.*")
    theme.set(Theme.DARK)
}
```
