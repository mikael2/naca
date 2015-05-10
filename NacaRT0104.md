# What is Naca? -->[click here](Naca0201.md) #

## NacaRT - JMX Console - Resources files ##

### Resources files (_Resources files) ###_

> To be used in transactional mode only.

> Displays the number of documents, files, ressources loaded in the pool ressources.
> The ressources pool can be reloaded during runtime.
> The request will be handled asynchronously, depending on the system load.
> This can modify one or more ressources files and to see the effect on the build screens without restarting Tomcat.

> The procedure to update a file ressource is:
    * Put the new file in the directory indetified by the variable `ResourcePath` of the configuration file `nacaRT.cfg`.
    * Request the ressources reload.