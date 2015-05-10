# What is Naca? -->[click here](Naca0201.md) #

# NacaRT - JMX Console - Elements #

## Introduction ##

> NacaRT uses JMX for action reporting and administration during runtime.
> This console is activated for Online execution mode.
> It is not available in batch or stored procedure mode.

> The SUN JDK is providing a Windows heavy client Jconsole.
> JConsole has been used successfully till now.
> Other LMX consoles are available on Internet.

> The following operations are available:
    * Memory consumption display
    * Application resource usage statics display and operation

## JMX Console ##

> The hosting tomcat server waits for JMX client requests on a specific port identified by a JVM command line parameter:

> `-Dcom.sun.management.jmxremote.port=xxx` where `xxx` is the port used for requests handling.

> The JMX console is described by Sun documentation.

## Memory consumption ##

### Memory types ###

> The Memory tab on the JMX console gives informations on the various types of memory.

> There 5 different memory pools, grouped in 2 main categories:
    * Heap memory pools.
> > > They are used to handle the Java objects. Their size can vary a lot during runtime.

  * Memory Pool "Eden space"

> > Very recent objects pool. Its size can vary a lot.
> > It is used to store the objects that just have been created.
> > It contains normally only objects having a very short lifetime.

  * Memory Pool "Survivor space"
> > Objects allocated for a certain lifetime.

  * Memory Pool "Tenured gen"
> > Objects having a very long lifetime.
> > It is critical that this pool is not completely loaded to avoid JVM exceptions.
> > JVM parameters allow to provision the pool, according to OS limits.
> > It is very impotant that its size does not go over the maximum amount of memory available to avoid JVM exception ("out of memory" exception).

  * Non-heap pools
> > They are used to handle the Java code programs. They size can vary depending on the number of programs loaded at a special time.

  * Code Cache
> > Pool containing the binary code of the classes recently loaded.
> > It can reach its maximum size, this will launch automatically a garbage collector.

  * Perm Gen
> > Pool containing the binary code of the classes loaded for a certain amount of time.
> > The goal of the class loader is to load/unload software objects in/out of the pool.
> > It is critic that this pool is not completely loaded to avoid JWM wxceptions.
> > A parameter `-XX:MaxPermSize=???m` allows to define the maximum limit in Mo, according to the OS.


> The garbage collector mechanism can be used from this interface.
> This is very useful to check the memory allocated.
> This however should not be done during at production time.

> The details of the history of the memory usage is available by clicking one of the green vertical ascensors.

### Memory usage sumup ###

> An object is freed form memory when it's not refered to anymore.
> That is when no other object references it.
> The garbage collector is a JVM internal thread that activates asynchronously when required by the JVM.
> It detects the objects that are not used anymore dans refress their memory block, so that this storage space becomes avaible for other objects usages.
> Some of these operations are non blocking, which is good, as it has a small impact on server execution time.
> However, some other operations are blocking.
> That is bad, as it means that user requests are suspending, thus takes a longer time to be processed.
> A great deal of nacaRT implementation is to minimize these blocking garbage collection.
> It is not possible to avoid at all these periods, but they are minimized at most by using caching strategies.
> NacaRT uses large amount of memory for caching and object reuse.

### Heap memory pools ###

> These pools are used by the JVM to store java data objects.
> The Eden space is used for storing only short-lived objects.
> It's garbage collectet often. It's not a blocking one, and is named "Copy" in the JMX console.
> The purpose is to remove temporary used objects, or the send them to the "Survivor space" heap.
> This space can vary from 0 byte to 2.5 Gb in 1 or 2 minutes, as a lot of small objects are allocated and destoy very fast.

> The "survivor space" contains objects with a middle to long live time. It size is not large and vary from 0 to 200 Mb.

> The "tenured gen" is the pool that holds long term objects.
> For example, sql prepared statements are stored in caches associated with the db sql connection.
> The object may live all day long, if they are used often enough.
> In that case, these objects won't be removed form this pool.
> However, if the sql prepared statement is not re-used within a certain amount of time, the nacaRT internal GC thread will detect that it's obsolete and will take it out of this cache.
> Thus, when the JVM garbage collector thread will activates, it will free the memory blocks used by the prepared statement.
> This operation is blocking !

### Non-heap memory pools ###

> These pools are used to store java code, not data.
> Java code is loaded in memory by a class loader which loads in memory the `.class binary code.`
> This code is managed almost a data: it's also garbage collected.

> There are only 2 pools:
    * "Code cache" that holds short lived code classes.
    * "Perm gen" that holds long lived code classes.

> In the case of cobol like programs, they are all cached by nacaRT, thus are have a natural tendency to live a long time.
> Thus, they are transfered by the JVM garbage collector to the "Perm gen" pool.
> This is hopefully not a blocking operation.

### JMX console displays ###

> All these 5 pools current level are displayed in the tab "Memory" of the JMX console.
> The garbage collection times is also displayed.

### Threads ###

> The details about the active threads can be displayed.

> The details on the execution of a thread can be displayed by clicking on an entry of the list "live thread".

### Classes ###

> The number of the classes loaded and unloaded can be displayed anytime.
> Especially, the unload action of the programs and the "copys" can be displayed here.

### VM ###

> The different JVM parameters are displayed.