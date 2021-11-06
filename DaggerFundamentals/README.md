# Dagger Fundamentals
![DaggerAppArchitecture](https://user-images.githubusercontent.com/22313316/139607513-e279c37b-232a-4505-9926-863774d2cba7.png)

### What is a Dagger? 

Dagger is a library which generates code to initialize classes by instantiating and providing all of its dependencies. It allows the developer to use a class without worrying about initializing all of its dependencies explicitly. 

## Components
### What is a Component? 

Components are a way of stating in dagger, which dependencies should be bundled together and made available to a given instance. They provide a way for a class to request dependencies being injected through the `@Inject` annotation.

In the diagram above AuthComponent and MainComponent are sub-components of AppComponent.

## Modules
### What is a Module?

Modules in Dagger are units which consists of the dependencies and the locations where dependencies need to be injected `@ContributesAndroidInjector` states to Dagger where dependencies need to be injected and `@Provides` annotation tells Dagger what is the dependency. Modules are directed to components which control which dependencies need to go where.

## Scoping
### What is a Scoping?

Instead of an object existing for the lifetime of the application and creating unnecessary overhead. Scoping allows us to create objects which are alive for certain parts of the application. 
A common type of scope is `@Singleton` scope which means objects instantiated using this scope will be alive for the lifetime of the application.

By annotating a component with a scope we state to Dagger that, that component owns that respective scope 
