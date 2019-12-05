COMPX202-19B / COMPX242-19B Assignment 4
========================================
The Observer Pattern
--------------------

The main purpose of this assignment is to experiment with the Observer
Pattern. JavaFX includes several versions of it, but for this
assignment we are making our own.  This repository includes an
IntelliJ project as a starter program.  It is configured to use Java 8
so as to avoid difficulties with the use of JavaFX in later versions.  If 
you have another version of the Java SDK set up at home, you can download Java 8
(which is the name for version 1.8).  Java is happy to have multiple versions
on one machine.  You may find that you have to go into File/Project Structure
in the assignment project and reset the version to 1.8. Also make sure that 
the language level (lower in the same dialog) is set to 8.

15. Test your program to make sure that the area and perimeter are
    displayed correctly.  Explain how you tested your program in the 
	space provided below.


16. Consider the sequence of events involved in a click/drag operation
    to move a corner. Write down below the sequence of events and
    operations performed by the handlers, showing the class instances
    involved in each case. Note that there will in general be a very
    large number of mouse move events and consequential events - you
    should show one in detail and indicate that there are more.

````
> **Question 15**

> To make sure the calculations were preformed correctly I changed the values
of the rectangle height and width to = 10. This way the area should = 100
and the perimeter = 40. Upon moving the rectangle these results were shown.
This means my calculations are correct. To test the results were dispayed correctly
I simply ran the program. 


````

````
> **Question 16**
Disclaimer: Checked this question with Jemma Konig to see if I was on the right track.

> Mouse move event for the top left corner of rectangle;

-anchor[0].addListener(obs -> { ... when the observable value changes.
-Anchor an = (Anchor) obs; ... sets the observable change to the anchor points used on the squares.
-rectangle.setX(an.getCenterX()); ... sets the X value of rectangle by calling another instance
 called getCenterX() which returns the X point of the center of circular anchor.
-rectangle.setY(an.getCenterY()); ... sets the Y value of the rectangle to the center point of
the anchors Y value, exactly similar to how the X position is calculated.
-rectangle.setWidth() calls upon the anchor[1].getCenterX object and subtracts by an.getCenterX
this is calculating the X difference between 2 corner anchors and hence is the width.
-rectangle.setHeight() calls upon the anchors[1].getCenterY() object and subtracts by an.getCenterY 
this is calculting the Y difference between  2 corner anchors and hence is the height.
-after all the calculations are preformed the notifyListeners() object is called
 which updates the listener with current values. Without this line the perimeter/area cannot be shown in main.
-finally getChildren().add(anchors[0]); adds the created anchor and all its properties onto
the child object which is the scene of the application. Without this line of code the specific anchor will not show.
There are many more separate click/drag events occuring and this is a brief on only one.

````
