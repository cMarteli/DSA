******************
* GAME OF CATZ	*
******************
Written by: Caio Marteli 19598552

Description:
A very hungry feline wants it all!
The cat will wander around attempt to eat steal the food from every animal in the zoo!
The user may select the start point and end point and the cat will hit every location (given they are physically connected) then finish at the end point once he's done!
Option to not set an end point is also available

To run:

Compile the whole program using java compiler.
:~/$ javac *.java

The main class is contained in gameofcatz.java.
The program has 3 separate run modes.

// Help mode: (Displays help information)
:~/$ java gameofcatz 

// Interactive mode (Opens menu and allows user to enter information directly)
:~/$ java gameofcatz -i

// Simulation mode (Loads a given file; runs a simulation and then exports simulation data to the created output file)
:~/$ java gameofcatz -s input.txt output.txt

There are a couple of sample input files provided on the directory of the program.
input.txt AND in2.txt
THIS PROGRAM USES IT'S OWN INPUT FILES

PS.
The program automatically appends the ".txt" to file names so there's no need to write those in.