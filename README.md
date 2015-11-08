# LabyrinthGame-Java-Design-Pattern-Creational
Creational Design Pattern training exercice

The given source code consists in a game, in which robots (whose behaviour are defined in dedicated classes) try to escape from a labyrinth

Task 1: Application's main should no longer contain the exact class name of robot AI to be used. Instead, the choice should be delegated to a more flexible mechanism able to instantiate the robot AI associated to a symbolic name. Find and use the adequate pattern to do so.

Task 2: Once task 1 done, use the builder pattern to implement incremental labyrinth creation (by defining what kind of information is useful). Then, implement a "labyrinth file parser", relying on the previous labyrinth builder, allowing to instantiate a labyrinth by reading an ASCII-art description from a given file. Think about applying the Builder pattern elsewhere.
