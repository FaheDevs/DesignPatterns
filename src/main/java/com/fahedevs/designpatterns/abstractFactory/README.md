# ABSTRACT FACTORY PATTERN 

_explanation and implementation of the abstract factory pattern_

### SMALL INTRODUCTION TO THE ABSTRACT FACTORY PATTERN
> **important !**
> you need to have an idea about these two concepts :
> + Programming to the public interfaces
> + Choosing composition over inheritance


+ The Abstract Factory Pattern focuses on creating families of closely related objects.

+ A common example of these related objects is a GUI (Graphical User Interface) platform, which can produce user interfaces with various looks and feels.

+ In a GUI platform, widgets like windows, buttons, and scroll bars are closely related and belong to a single family, often determined by their visual style.

+ Programming the front-end of a library using the Abstract Factory pattern simplifies widget creation for different looks and feels.

+ The organization of widgets into families is one way to implement the pattern; another approach is to group widgets based on their functionality, like all buttons or scroll bars.

+ Each family of objects can have its own factory. The Abstract Factory pattern aims to create these objects using abstract interfaces at the root of factory and object hierarchies.

+ The key lesson of the pattern is that clients can interact with the entire object creation system using just two interfaces: one for factories and another for the objects to be created.

### INTENT AND APPLICABILITY 
The intent of the Abstract Factory pattern is to make it possible for a client to construct
a family of related objects by programming to a small number of interfaces, typically just
two: **one at the root of the class hierarchy that describes the objects** and **the other at the root
of a hierarchy of factory classes**.

You should consider using this pattern when:
+ the different possible customizations of all the objects can be characterized by com-mon themes (you may think of each theme as standing for a family of closely related objects);
+ all the related objects that belong to the same theme can be produced by the same factory class;
+ all factory classes that are required for the different possible themes can be manipulated through a common factory interface.

### THE ABSTRACT FACTORY PATTERN IN REAL-WORLD APPLICATIONS
This pattern is used by the software vendors who create similar-in-functionality yet unique-in-appearance web-based GUIs for commercial enterprises engaged in e-commerce.
Each such enterprise would want its customer-facing front-end to be unique. Yet, all such front-ends must do very similar things: 
+ provide a search widget that allows the customers to search for a product;
+ provide a product-browsing widget; provide a “shopping cart” widget; 
+ provide a widget that elicits shipping information from the customer; and so on.

In their generic form, all the widgets needed for an e-commerce site can be considered to constitute a family of widgets. 
In order to create the factories for the production of these widgets, a software vendor is likely to design a root factory interface that can then be implemented by a concrete class for the
customization needed for the look-and-feel for a particular e-commerce client. 
You can think of the root factory interface as defining a generic factory. Utilizing the concrete factory class created specifically for an e-commerce client, the client would only need to call the methods in the root interfaces of the widget hierarchy
and the factory hierarchy in order to produce the different GUI components that have the desired background/foreground colors, shapes, layouts, etc. The client would not need to know the precise details of what classes work together for the look-and-feel for the client’s
web-based business portal.

# PLAYING WITH THE CODE 
Consider the case when we want our factories to produce the following three types of mag-
ical objects: MagicWands, Broomsticks, and Owls. Let’s also say that each of the three
wizarding schools, Beauxbatons, Durmstrang, and Hogwarts, would like for these objects
to be customized for its own students, with the customization consisting of imprinting the
school crest on the objects.


![_families of objects_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FabstractFactoryPattern%2Fobjectsfacotories.png)

![_factory Hierarchy_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FabstractFactoryPattern%2FfactoryHierarchy.png) ![_classHierarchy_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FabstractFactoryPattern%2FclassHierarchy.png)

The class diagram is a top-level view of our demonstration of the Abstract
Factory pattern. The only executable class in the code, **_DiagonAlleyRetailer_**, is a client
of two class hierarchies, one headed by the root **_class Enchanted_** and the other headed by
the root **_class Factory_**. The former root class serves as the interface for the magical-object
classes and the latter does the same for the factory classes.

![_specificationlevelClassDiagram_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FabstractFactoryPattern%2FspecificationlevelClassDiag.png)

The **_FactoryStore_** class has been implemented using the ***Singleton pattern*** that is because we want only one factory store to service all the retailers.
The Singleton pattern is implemented by making the constructor private, as you see in the
code , and also by making available a method like `makeFactoryStore()` for
acquiring a reference to the one and only one factory store that is allowed to come into
existence.
