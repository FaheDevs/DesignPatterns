# BUILDER PATTERN

_explanation and implementation of the builder pattern_ 

### INTRODUCTION TO THE BUILDER PATTERN
This pattern is
about constructing instances and their variants from a class that is complex in the following
ways: 
+ Each instance is composed of several parts that are in non-trivial relationships vis-
à-vis one another.
+ The clients are interested in a small number of variants of a generic
instance.
+ The complexity of instances is such that a client cannot be expected to
know whether or not all the conditions for instance construction can be satisfied at any
given time. 

The last reason requires that we insulate the object builders from the clients by
interposing a director in-between. It would be the director’s job to know whether or not the
prevailing conditions would allow for an instance to be constructed in at least a piecemeal
fashion, if not in one fell swoop

![_ConceptualbuilderPatternClassDiagaram_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FbuilderPattern%2Fbuilder1.png)

### INTENT AND APPLICABILITY

When object construction involves algorithmic steps, the intent of the Builder pattern is
to organize the object construction details in an efficient representational hierarchy and
insulate the clients from the complexity of how the objects are put together.
The pattern should be used when : 
+ object construction involves algorithmic detail regarding how its different parts come
together and when this detail is independent of the choice of the parts for the different
customizations of the objects.
+ you must mask the algorithmic construction details of object construction from the
clients of a class hierarchy.
+ it is possible to think of all the objects desired from a class hierarchy by the clients
as different customizations of a generic form so that you can place the construction
steps for the generic form in a base class and the customization steps in the different
subclasses.

### THE BUILDER PATTERN IN REAL-WORLD APPLICATIONS

+ The Builder pattern is useful for applications involving the instantiation of complex objects that would be too cumbersome for clients to construct directly.
+ It is particularly valuable when dealing with objects that require multi-step construction with precedence constraints.
+ The pattern introduces the concept of a "director" to create a more user-friendly interface for clients for object construction.
+ It is also beneficial when constructing complex objects with a large number of parameters that may become available gradually.
+ The director and concrete builders in the Builder pattern facilitate the gradual accumulation of parameter information and object instantiation.
+ The pattern allows for the creation of object variants by customizing the logic in concrete builders based on a base builder class.

For example, let's consider a software tool for online customer profiling, where a profile's construction requires a significant number of parameters.
The Builder pattern is well-suited for handling the complex process of customer profiling, especially when dealing with precedence constraints in data collection and processing.
It simplifies the categorization of potential customers into subclasses of a base profile class based on collected data and preferences.

# PLAYING WITH THE CODE 

![_conceptualClassDiagram_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FbuilderPattern%2FconceptualClassDiagram.png)

In here the _**PotionMaker**_ plays the role of the _**Builder**_ as shown in the conceptual class diagram of the builder pattern 

![_specificationClassDiagram_](..%2F..%2F..%2F..%2F..%2Fresources%2Fstatic%2FbuilderPattern%2FspecificationClassDiagram.png)

Summary of the roles played by the more prominent classes :
+ The demonstration involves a root builder class, which in our case is **_PotionMaker_**,
that knows about all the individual parts (in our case, the ingredients) that go into
the building of the objects (in our case, making of the potions). We declare the names
of all the ingredients in the **_PotionMaker_** class.
+ We provide the root builder class, PotionMaker, with default implementations for
how to prepare each part (that is, each ingredient). In our case, the default implementations will simply declare its inability to prepare a part (in our case, its inability to
prepare an ingredient).
+ We provide the abstract root builder class with an instance creation method (in our
case, the potion-making method called `makePotion()`) whose implementation in the
root class just throws an exception. Therefore, a concrete potion maker obtained by
subclassing from the root PotionMaker class must provide an override for the default
implementation inherited from the root class.
+ We extend the root builder class into concrete builder classes for the different types
of objects needed by the clients. In our case, that boils down to extending the abstract
root PotionMaker class into concrete potion-making classes.
+ In the implementation of each concrete potion-making class, we provide override
implementations for those ingredient preparation methods that are needed for the
potion. And in the override for the `makePotion()` method, we make sure that all
of the constraints, such as those on the order in which the ingredients are combined,
are fulfilled.
+ We define a Director class that completely insulates a client from the internal details
of the potion-making hierarchy of classes. The Director knows about the overall
needs of the concrete potion-making classes. It asks a concrete potion-maker class to
make a potion only when all of the ingredients for that potion are on hand.

The _**Director**_ class defined in this
section satisfies the following three requirements:
+ It isolates a client from the potion makers. By isolation in this context, we mean the
following: A client would request a potion merely by naming it. We do not expect the
client to know what ingredients go into the potion. It is the job of the Director to
translate a client’s request into a form that would be understood by the potion makers.
+ The Director asks a concrete PotionMaker class to supply a potion only after all of
the ingredients for that potion have become available.
+ Although the Director class must be aware of the overall requirements of the individual potion makers, it must not be privy to the fine details concerning the making of
the potions. 