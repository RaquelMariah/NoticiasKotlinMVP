# Notícias Kotlin MVP

Aplicativo Android que recebe dados da ***News API*** e exibe as notícias em lista.

Para o desenvolvimento desse aplicativo, fui utilizado:
+ [News API](https://newsapi.org)
+ [Kotlin](https://kotlinlang.org)
+ [Coroutines](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAo5qABhBdEiwAOtGmbvyr0ukd-jlKwfu5vfgBcU1I0YcPDpfNwO8D2GWWAvE2FWGMrgigoRoCLAsQAvD_BwE&gclsrc=aw.ds)
+ [Retrofit](https://square.github.io/retrofit/)
+ [Room](https://developer.android.com/training/data-storage/room)
+ [MVP Architecture](https://pt.wikipedia.org/wiki/Model-view-presenter)

## Arquitetura MVP

Em MVP a camada ***Presenter*** assume a função de mediadora. A ***View*** é responsável por manipular os eventos UI. Finalmente, a ***Model*** se torna estritamente um modelo de domínio.


## Configurações do Projeto

Para executar o projeto em seu dispositivo, é necessário realizar o cadastro no site [News API](https://newsapi.org) e obter a chave da api ***(API_KEY)***.
Em seguida, substitua o conteúdo na classe ***Constants***.


## TO DO

Esse projeto está em construção. Será necessário adicionar:

+ [Testes Unitários](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [Testes de Instrumentação](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [CI](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)
+ [Publicação na Play Store](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)

