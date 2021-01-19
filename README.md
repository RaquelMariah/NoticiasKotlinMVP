# Notícias Kotlin MVP

Aplicativo Android que recebe dados da ***News API*** e exibe as notícias em lista.

Para o desenvolvimento desse aplicativo, foi utilizado:
+ [News API](https://newsapi.org)
+ [Kotlin](https://kotlinlang.org)
+ [Coroutines](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAo5qABhBdEiwAOtGmbvyr0ukd-jlKwfu5vfgBcU1I0YcPDpfNwO8D2GWWAvE2FWGMrgigoRoCLAsQAvD_BwE&gclsrc=aw.ds)
+ [Retrofit](https://square.github.io/retrofit/)
+ [Room](https://developer.android.com/training/data-storage/room)
+ [MVP Architecture](https://pt.wikipedia.org/wiki/Model-view-presenter)

## Arquitetura MVP

Em MVP a camada ***Presenter*** assume a função de mediadora. A ***View*** é responsável por manipular os eventos UI. Finalmente, a ***Model*** se torna estritamente um modelo de domínio.

![mvp](https://user-images.githubusercontent.com/45218570/105050872-fb982a80-5a4c-11eb-8afd-66e2e723686e.png)



## Configurações do Projeto

Para executar o projeto em seu dispositivo, é necessário realizar o cadastro no site [News API](https://newsapi.org) e obter a chave da api ***(API_KEY)***.
Em seguida, substitua o conteúdo na classe ***Constants***.


## Telas


***Tela Inicial***           
:-------------------------:
![WhatsApp Video 2021-01-19 at 11 56 00](https://user-images.githubusercontent.com/45218570/105073113-62294280-5a65-11eb-9523-5406da069586.gif)



  ***WebView Noticias***          
  :-------------------------:
  ![WhatsApp Video 2021-01-19 at 14 51 50](https://user-images.githubusercontent.com/45218570/105074266-e4663680-5a66-11eb-931b-945f12dca925.gif)
  
  


  ***Favoritos***        
  :-------------------------:
  ![favorites](https://user-images.githubusercontent.com/45218570/105074715-7c642000-5a67-11eb-9324-d7c3cfc9ce58.gif)
  
  

## TO DO

Esse projeto está em construção. Será necessário adicionar:

+ [Testes Unitários](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [Testes de Instrumentação](https://www.androidpro.com.br/blog/desenvolvimento-android/criando-testes-para-seu-aplicativo-android/)
+ [CI](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)
+ [Publicação na Play Store](https://medium.com/android-dev-br/configurando-ci-cd-com-github-actions-e-firebase-app-distribution-para-projetos-android-8df02096610b)

