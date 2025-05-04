# Boilerplate-Android

Разбор проекта разделен на серию статей:

- [Single Activity с Navigation Component. Или как я мучался с графами. Boilerplate ч. 1](https://habr.com/ru/post/654599/)
- [Запросы в сеть с Clean Architecture и MVVM. Boilerplate ч. 2](https://habr.com/ru/post/667026/) [НЕ АКТУАЛЬНО]
- [Запросы в сеть с Clean Architecture — Обработка ошибок с сервера. Boilerplate ч. 3](https://habr.com/ru/post/673180/)
- [Запросы с пагинацией с помощью Paging 3 и работа над ошибками. Boilerplate ч. 4](https://habr.com/ru/post/682120/) [НЕ АКТУАЛЬНО]

- - -

#### [Modules Graph:](GRAPH.md)

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
  :feature:bar --> :core:presentation
  :app --> :core:presentation
  :app --> :db
  :app --> :feature:foo
  :app --> :feature:bar
  :feature:foo --> :core:data
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
