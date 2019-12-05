COMPX202-19B / COMPX242-19B Assignment 4
========================================

Due date extended to **Tuesday 13th August at 11:30 pm**.

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

Instructions
------------

Fork this project and **make sure that the visibility of your new project is set to
private**. Clone your new repository to your
computer. As you work on the project, remember to commit regularly with descriptive messages.

1. Main.java includes the editable triangle from lecture. Modify the
    code to draw a second editable triangle next to the existing one.

2. Add code to the method `start()` to draw a rectangle (in addition 
   to the two triangles) by creating an instance of the class
    [javafx.scene.shape.Rectangle](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html)
    and adding it to the root Group. Style the rectangle like the
    triangle (colours, line thickness, etc).

3. Move the code for drawing the rectangle into a new class called
    EditableRectangle. Having looked at the documentation for the
    JavaFX Rectangle class, choose an appropriate signature for the
    EditableRectangle constructor (ie. set parameters for the 
	constructor).

4. Add a single anchor to EditableRectangle on the top left corner.
    Your anchor should allow a user to move the whole rectangle 
	without altering the width and height.

5. Add a second anchor to EditableRectangle on the bottom
    right corner.  Moving this new anchor should resize the
	rectangle without moving the top left corner.  You should find that
	moving the top left corner anchor will still move the whole rectangle, 
	but will leave the bottom right anchor behind.

6.  Modify your EditableRectangle so that the top left anchor just 
    moves its corner - also resizing the rectangle.
	
7. Experiment to see what happens when the corners of the rectangle
    cross over (e.g. drag the bottom right anchor up and to the left,
    beyond the top left anchor).

8. Modify your code if necessary so that the rectangle is displayed
    even if the two anchors are crossed over. The anchors will no
    longer correspond to the top left and bottom right corners;
    they'll be two arbitrary corners. Note: Completing this step isn't
    essential for completing the remaining steps.

9. Modify the EditableRectangle class so that it implements the
    MyObservable interface in a similar way to the Anchor class. The
    listeners should be notified whenever the rectangle is changed.

10. In the `start()` method, add a listener to the EditableRectangle
    instance that writes a message to the console using
    _System.out.println_ whenever the rectangle changes.

11. In the `start()` method, add a
    [javafx.scene.text.Text](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/Text.html)
    node that displays some text. Position the text near the top right
    corner of the stage.

12. Add methods `getWidth()` and `getHeight()` to the
    EditableRectangle class.

13. Modify the listener added in the `start()` method so that instead
    of printing a message to the console, it sets the text of the Text
    node from step 10 to the area of the rectangle (i.e. width \*
    height). Check that the area is updated as the rectangle is
    resized.

14. Add a second Text node, and use a second listener to update it
    with the perimeter of the rectangle. Indicate which number is the
    area and which is the perimeter, either by changing the text or by
    adding more Text nodes.

15. Test your program to make sure that the area and perimeter are
    displayed correctly.  Explain how you tested your program in the 
	space provided below.


16. Consider the sequence of events involved in a click/drag operation
    to move a corner. Write down below the sequence of events and
    operations performed by the handlers, showing the class instances
    involved in each case. Note that there will in general be a very
    large number of mouse move events and consequential events - you
    should show one in detail and indicate that there are more.

17. Add anchors to the EditableRectangle's remaining two corners which
    allow resizing the rectangle in all directions while maintaining
    its rectangular shape. Partial marks can be achieved for a written
    analysis of this problem.

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

Submitting
----------

Push your changes to your GitLab repository. Ensure that you can see
your changes on GitLab.

Grading
-------

| Weighting | Allocated to |
|:----------:|------|
| 10% | Correct repository usage and settings |
| 20% | Steps 1-3 |
| 20% | Steps 4-8 |
| 20% | Steps 9-14 |
|  5% | Question 15 |
| 10% | Question 16 |
| 15% | Step 17 |
