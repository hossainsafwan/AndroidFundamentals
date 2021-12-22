# Services
## What is a service? 
A service is an application component which performs long running application in the backgroud such as downloading a file or playing music. It dos not require a user interface.

# Types of Services
These are the three different types of services:

1. `Foreground Service`
2. `Background Service`
3. `Bound Service`

`Foreground Service`: A foreground serivce has a user interface to it. It must display a notification so that the user is actively aware that the service is running.

`Background Service`: A background service is a serice which is not noticed by the user. for example is an app used a service to compress a file being stored in the hard disk then that would be a background service.

`Bound Service`: When an application component binds to a service and creating a client-server like relationship we call is a bound service. It is called a client-server like relationship since the service can send and receive requests. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed.


