# Fed Census 1930 Data Analysis

Use the run batch script to run the main java file (`FedCensus.java`) with certain command line arguments

```run```

Runs all the methods with the word Stuff at the end of the method name. This should run all of the tasks.

```run %X```

will run the method named `%X + "Stuff"`. If no method is found, the program will print the stack trace of a `NoSuchMethodException`.

Each method is named by what the keys are to the HashMap it uses within the method, corresponding to the different tasks.

You can also directly run the FedCensus.java file without the run script and the command line arguments will work exactly the same.