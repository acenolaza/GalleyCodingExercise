# GalleyCodingExercise
Three monkeys and three wolves want to get to the other side of a river. There is a small boat, which can fit only two. To prevent a tragedy of a wolf eating a monkey, there can never be more wolves than monkeys together. The solution is as follows if done with five input steps requested from the user where the user must be prompted each time with which two will row across and which one will row back to get another.

1 wolf and 1 monkey row there, monkey rows back. 
2 wolves row there, 1 wolf rows back. 
2 monkeys row there, 1 monkey and 1 wolf rows back. 
2 monkeys row there, 1 wolf rows back. 
This one wolf takes the remaining wolves to the other side.

## Code walkthrough

Game solution was written in Kotlin since I always try to learn new things while solving this kind of exercises.

I also did some research on how to build binaries for multiples platforms since I'm using Windows 10 but the person testing this could be using MacOS or Linux. Kotlin provides a technology called Kotlin/Native which allows compiling Kotlin code to native binaries, which can run without a virtual machine. This produces a self-contained program that does not require an additional runtime or virtual machine. The downside to this has been testing and debugging the code from withing IntelliJ IDEA.

Ok, enough introduction now let's talk code...

Game structure is pretty simple. I have an App class which has a main method in charge of starting the game. All the game logic resides in the Game class.
This class has a method with a loop that performs a cross and checks if game has reached the goal on each iteration. On each cross the program asks the user to input the animals that will board the boat and performs some validation before actually crossing them to the other shore. If validation passes the animals are crossed and then the boat will be on the other shore ready for a cross back.

![alt text](https://imgur.com/U5la43c)