### COMPX202 -  Mobile Computing and Software Architecture
Assignment 4 - The Observer Pattern
========================================

#### Due on **Friday 17th April at 8pm**

-------------------------

The main purpose of this assignment is to experiment with the Observer
Pattern. JavaFX includes several versions of it, but for this
assignment we are making our own.  This repository includes an
IntelliJ project as a starter program. 

Instructions
------------

### Setup
[See PDF for more detailed instructions]
1. Clone this repository using the button at the top of the project
    page

2. Import the project into IntelliJ from Version Control (pasting the URL of the project)

3. On GitHub, create a new **Private**, empty repository named COMPX202-assignment4-3170000 (**Use your student ID instead of 3170000**)
 **Set the visibility of your project to Private** 

4. Invite the teachers (azanibellato, samminweng) to your Private repository

5. Change the remotes in IntelliJ to point to the new repository (from VCS > Git > Remotes...)

6. Push the files to the new repository (VCS > Git > Push)

7. Try running Main.Java. You will need to set up the run configurations in IntelliJ for JavaFX (VM options --module-path ... --add-modules javafx.base,javafx.controls with your own JavaFXpath)

### The assignment
1. Main.java includes the editable triangle from Week 7 lecture. Modify the
    code to draw a second editable triangle next to the existing one.

2. Add code to the method `start()` in Main.java to draw a rectangle (in addition 
   to the two triangles) by creating an instance of the class
    [javafx.scene.shape.Rectangle](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/shape/Rectangle.html)
    and adding it to the root Group. Style the rectangle like the
    triangle (colours, line thickness, etc).

3. Move the code for drawing the rectangle into a new class called
    EditableRectangle (in a new file EditableRectangle.java). Having looked at the documentation for the
    JavaFX Rectangle class, choose an appropriate signature for the
    EditableRectangle constructor (i.e. set parameters for the 
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

10. In the Main.java `start()` method, add a listener to the EditableRectangle
    instance that writes a message to the console using
    _System.out.println_ whenever the rectangle changes.

11. In the Main.java `start()` method, add a
    [javafx.scene.text.Text](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/text/Text.html)
    node that displays some text. Position the text near the top right
    corner of the stage.

12. Add methods `getWidth()` and `getHeight()` to the
    EditableRectangle class.

13. Modify the listener added in the Main.java `start()` method so that instead
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

> Write your answer here


````

````
> **Question 16**

> Write your answer here


````

Submitting
----------

Push your changes to your private GitHub repository. Ensure that you can see
your changes on GitHub.

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