# Dagger Fundamentals
![DaggerAppArchitecture](https://user-images.githubusercontent.com/22313316/139607513-e279c37b-232a-4505-9926-863774d2cba7.png)

### What is a Dagger? 

Dagger is a library which generates code to initialize classes by instantiating and providing all of its dependencies. It allows the developer to use a class without worrying about initializing all of its dependecies explicity. 

## Components
### What is a Component? 

Components are a way of stating in dagger, which dependencies should be bundled together and made available to a given instance. They povide a way for a class to request dependencies being injected through the `@Inject` annotation.

In the diagram above AuthComponent and MainComponent are sub-components of AppComponent.

## Modules
### What is a Module?

Modules in Dagger are units which consists of the dependencies and the locations where dependencies need to be injected `@ContributesAndroidInjector` states to Dagger where dependencies need to be injected and `@Provides` annotation tells Dagger what is the dependency. Modules are directed to components which control which dependencies need to go where.
