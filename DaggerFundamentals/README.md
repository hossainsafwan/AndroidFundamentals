# Dagger Fundamentals
![DaggerAppArchitecture](https://user-images.githubusercontent.com/22313316/139607513-e279c37b-232a-4505-9926-863774d2cba7.png)

### What is a Dagger? 

Dagger is a library which generates code to initialize classes by instantiating and providing all of its dependencies. It allows the developer to use a class without worrying about initializing all of its dependencies explicitly. 

## Components
### What is a Component? 

Components in Dagger decide how objects need to be instantiated and in which order objects need to be instantiated.
In the diagram above AuthComponent and MainComponent are sub-components of AppComponent. 
Components also consist of their own scopes which ensures objects are instantiated and retained only for the lifetime that they are needed and 
not for too long, therefore attenuating overhead. In the example above `Appcomponent` has `@Singleton` scope; `AuthComponent` has `@AuthScope` and
`MainComponent` has `@MainScope`.

## Modules
### What is a Module?

Modules in Dagger are units which consists of the dependencies and the locations where dependencies need to be injected `@ContributesAndroidInjector` states to Dagger where dependencies need to be injected and `@Provides` annotation tells Dagger what is the dependency. Modules are directed to components which control which dependencies need to go where.

## Scoping
### What is a Scoping?

Instead of an object existing for the lifetime of the application and creating unnecessary overhead. Scoping allows us to create objects which are alive for certain parts of the application. 
A common type of scope is `@Singleton` scope which means objects instantiated using this scope will be alive for the lifetime of the application.

By annotating a component with a scope we state to Dagger that, that component owns that respective scope 
