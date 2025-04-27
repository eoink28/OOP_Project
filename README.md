## Getting Started
Welcome to my OOP project!

I am looking forward to creating and putting my OOP skills to the test and creating this Java application!  
I am aiming personally for Level 3 ("Level 3: You can also use the GUI to enter in new rows to the dataset with feature values and known label values (i.e., expand your training dataset). This should then recalculate the various permutations totals for the rules (i.e., recalculate the classifier, based on pressing a button)").

I think this will be challenging but also enjoyable!  
My personal dataset was "PolicyIsActive".  
The very first thing I had to do was determine what this actually means!  
I have taken it as "Is an insurance policy active?"
Based off of this, I had to create a CSV dataset with sample data to train the predictor.


## Control Class

This class is used to run the program.  
I thought about not having a Control class, but I have liked working with one all throughout the year and including up to this point.  
It makes running the app a bit easier, and it’s easier to manage objects etc.


## GUI Class

This class is used to create everything to do with the GUI.  
The graphical user interface is what the user actually interacts with when using this app.  
To me, it’s important that the GUI is clean and the user is able to understand how to use it in a very short amount of time.


## Dataset Class

The Dataset class is used to process the dataset CSV file.  
It opens and handles all the information.  
It also allows the program to add new rows to the dataset if the user wants to expand the training data through the GUI.


## Predictor Class

This class handles making the predictions.  
It checks the input from the user against the dataset, counts the matching rows, and predicts **"Yes"**, **"No"**, or **"TIE"** based on which has more matches.  
It also supports retraining when new data is added.



