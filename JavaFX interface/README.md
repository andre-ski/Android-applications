COMPX202-19B / COMPX242-19B Assignment 2
Experimenting with a big Java Package – JavaFX
==============================================

The goal of this exercise is to experiment with the JavaFX system for building user interfaces.
JavaFX is the recommended library for making user interfaces in desktop applications with
the current version of the Java language and development system.

JavaFX is described in the documentation supplied by Oracle,
found [here](http://docs.oracle.com/javase/8/javafx/api/toc.htm).
There is also a link in the notes for lecture 5.

This assignment has 3 parts:
 1. Taking a 'sample' program (different from the one examined in class) and experimenting to find out how it works.
 2. Extending or rewriting the sample program to layout a form in JavaFX.
 3. Adding callbacks to make your program interactive.

Task Questions
----------------

```
Question 1
What does A2.java do when you enter text?

If you enter a word into the censor textbox ie. 'Andre' and you enter 'Yoink' into the replacement textbox, when I enter 'Andre' into the raw input it replaces
it with 'Yoink'. Any word in the raw input which matches a word in the censor box, is automatically replaced with the word in the replacement textbox.

Question 2
Describe three experiments you conducted on A2.java and in each case explain what you learned from the results.

Experiment 1: I commented out the line of code "VBox root = new VBox();" as I wanted to see what it did. When I ran the code it came up with multiple compiler errors and didn't run the application. I can see that I am getting an error
on all the objects based on this class. E.G. "A2.java:64: error: cannot find symbol root.getChildren().add(label4);" I have learntthat VBox has something to do with the layout of objects as none of the labels work anylonger. A quick
google confirmed this, saying "VBox lays out its children in a single vertical column..." - source: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html

Experiment 2: I changed text1(2,3).setOnKeyReleased to text1(2/3).setOnMouseReleased. This changed the event listener to change the text when the mouse clicked off the current text box. Instead of automatically changing the same raw text with
the replacment text on key press the user now has to click on a non focused text box before anything happens. I have learnt that onKeyReleased feels a lot more fluid than onMouseReleaxsed listener and I have learnt more about how onKeyReleased works.

Experiment 3: I edited the code "Scene scene = new Scene(root, 400, 200);" to "Scene scene = new Scene(vbox11, 400, 200);". Changing root to vbox11. I did this because both root and vbox11 are VBox() classes. Therefore, I am curious to see
what would happen. Unsurprisingly the application did not compile, and more interestingly I got an error "VBox@36eda903is already inside a scene-graph and cannot be set as root". This means that I cannot use the vbox11 because it is inside
of the scene of the root VBox scene. I then commented out all the code relaed to vbox11 and this made the Censor textbox disappear. Not only this, but when I put for example "d" in the replacement textbox, and then an "a" in the raw input text
box, the resulting word in the raw input changes to "dad". So instead of replacing a word it does not know, it adds whatever is entered in the replacement textbox to the front and end of the raw input. I have learnt that, without the 
censor textbox the replacement textbox the class "applyCensorRules()" cannot perform "censoredText = rawText.replace(censored, replacement);" properly. Instead setting censored to a null value.

Question 3
For each of the classes HBox, Text and TextField briefly describe (a) the purpose of the class.

HBox: Is a class that organises its children (inheritance) in a form into horizontal columns . The h=horizontal, therefore in VBox the v=vertical. In this code, vbox11 and vbox12 are children of hbox1 which inturn is a child of root.
This is how the form is organised into vertical / horizontal labels and textfields. The vbox11 (Censored) and the vbox12 (Replacement text) are placed on the same level whereas the other labels are placed after the hbox1 on the next level.

Text: This class defines a node that can contain text, dates, numbers etc.

TextField: This class provides a small textbox/text field in a graphical manner for the user to enter text or for the application to output text into. 
```

Task Questions
----------------

```
Question 1.
What would happen if you used the key press event rather than the key release event.

On key press the call back function would immediatley be called, instead of having to wait for the key to be released first. This is a specificially
important feature in games, or other high paced environments where users are moving there characters quickly, they do not want to have to wait till the release
to move - would not feel as fluid. In the context of this assignment the key down or key release don't make too much difference. 

Question 2.
Is the use of key release satisfactory?  Are there situations in which edits are not detected? (hint: try using the mouse)

In most cases I believe it is satisfactory, especially if you are tabbing across the different text fields. However, if you right click on a 
text field with your mouse and edit it by "copy/paste/delete" etc, the application does not register a change. The mouse click is not considered
a key release and there would need to be a MousInputListener method as well the KeyInputListener to make sure the application could always respond.

```
