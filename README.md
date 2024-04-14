# PolynomialCalculator
## Table of Contents

1. [Assignment Objectives](##Assignment-Objectives)
2. [Problem Analysis](##Problem-analysis)
3. [Design](#Design)
4. [Implementation](#Implementation)
5. [Results](#Results)
6. [Conclusions](#Conclusions)
7. [References](#References)

## 1. Assignment Objectives
The main objective of this assignment is to design and implement a polynomial calculator that can perform the following operations:
-	addition
- subtraction 
-	multiplication 
-	division
-	derivation
-	integration

## 2. Problem Analysis 

The problem is quite straightforward: we must create some sort of application that performs arithmetic and functional operations over polynomials. There is no need to develop or choose between algorithms for any of those operations because the brute force solution is optimal. Some abstraction is necessary: in mathematics a polynomial is represented as ∑_(k=0)^n▒〖a_k X^k 〗 where X is the unknown, a_k is the coefficient and k represents the power. This way of looking at a polynomial can be simplified drastically if we want to store it. Because all polynomials follow the same representation pattern, we can imagine them as vectors (arrays) of coefficients where the kth element is the integer that multiplies X^k in the mathematical expression. This means we must store only the coefficients of each polynomial in an abstract data type.
  
The polynomial calculator is designed to perform the operations mentioned in the first chapter if the required number of polynomials is provided. The polynomials need not to be strongly typed (i.e. coefficient * X ^ power where coefficient and power are integers), but the order convention must be satisfied for correct functionality (for example, X^2*100 is not a valid format; it should be replaced with 100*X^2 or 100X^2). Being a simple application, there are not a lot of steps to be followed when one intends to use it: 

- Run the application: a pop-up window appearing means the application is ready to go. The window is composed of two parts: the part where the background is pink is where the polynomials should be inserted (the first two text boxes that are editable from top to bottom), and the part with the green background where buttons are placed. Each button performs the operation that its name indicates. If the input is wrong or does not respect the order convention a smaller pop-up window appears announcing the user that there is a problem regarding the input. Only if the input is correct does the computation begin.

- The user inserts either one polynomial (if he intends to find the result of derivation or integration) or two (for any of the other operations). When subtracting/dividing the first polynomial (field from top to bottom) acts as the minuend/dividend and the second polynomial (field from top to bottom) acts as the subtrahend/divisor.

- The user clicks the button corresponding to the operation he desires. The result is displayed in the third field in the part of the screen with the pink background. 

- By the time the result is displayed the calculator is ready to perform a new one, so the user is free to go back to step b)

The user diagram describes the dependencies between the user’s interactions and the system the polynomial calculator is. The aim of the user is to compute the result of one of the mentioned operations, but the system does not let him do this unless the parameters are provided. At the same time, for enhanced development possibilities the functionality of the application is divided into two: the operations performed on a single polynomial and the operations that require two polynomials. These two are the extensions of the general functionality of the calculator. The current user represents the only human instance needed.

 <p align="center">
  <img src="https://github.com/l7aur/Polynomial-Calculator/assets/81981519/c961eef2-b73b-4fa0-b919-6664625daa8d" />
</p>

## 3. Design

I have chosen the classical approach in solving projects that require graphical user interfaces: the calculator is divided conceptually into two main directories – backend and frontend. The backend is where the processing and the computation happen and everything that is related to the appearance is grouped in the frontend package. 

The backend package consists of two abstract data types defined by me: String Polynomial and Polynomial. In addition to these there are two other classes that I regard as utility resources: Pair and Pattern. My implementation requires all these to convert the input polynomial into an array of coefficients. 

The frontend package is divided based on a layout of slices. Each object in the window acts as a stamp that is applied over the previous layer. This means there are 2 main panels: the InputPanel (pink background) and the ControlPanel (green background). In the InputPanel there are 2 other pane-like components: a ReadPanel that consists of two fields where the polynomials are supposed to be inserted and an OutputPanel where the result of the computation is displayed. The purpose of the ControlPanel is to house the 6 buttons that perform the operations enumerated in the first section. Each button is associated to an ActionListener that manages the interaction of the user with the medium of the application.


## 4. Implementation

The implementation of the classes and of the main methods is discussed:

-	StringPolynomial
This class acts as a wrapper for the input data. A polynomial inserted in a JTextField is stored as a string in memory. The purpose of the StringPolynomial class is to store this string representation 	and by means of methods to decompose it into monomials (tokens) that are then processed until 	a corresponding pair (degree, coefficient) is found. Such a pair is inserted into a Map.

    -	.tokenize() converts a string into an array of monomials based on pattern matching (patterns are provided by the Patterns class). It also checks for the integrity of data: only polynomials that respect the canonical representations are accepted, however there are cases where the validation algorithm fails (X200 becomes X+200 instead of 200*X). My approach to tokenizing the string is to start from the most specific pattern and to decrease its accuracy step-by-step (i.e. from 1*X^1 to X). If characters are left, the string is rejected, and a pop-up window is displayed.
    -	.getPolyMapping() is the most important method of the class because it converts the array of tokens (monomials) into a map of degrees – coefficients. This process is performed on each token: its sign is defined as 1 (positive), if a minus is encountered it becomes -1, then the coefficient is processed and converted into an Integer by means of another method. The unknown (X) is jumped, as well as the ‘^’ character. The exponent of the unknown is processed the same way as the coefficient. 
    -	.convertToPoly() calls the above-mentioned methods and generates a Polynomial-class object 

-	Polynomial
The main object that is the parameter of all the operations.

    -	.add(Polynomial polynomial) performs the addition of two polynomials. The result is stored in a new Polynomial and returned.
    -	.subtract(Polynomial polynomial) subtracts polynomial from this and returns the result. The operation calls a helper method that generates the negation of the second polynomial, then it is added to the object subtract is called on.
    -	.multiply(Polynomial polynomial) generates a new polynomial that is the result of the multiplication of this and the Polynomial parameter. The way this is done is the basic, brute-force, for-in-for algorithm.
    -	.division(Polynomial polynomial) returns the quotient of the division of this to the Polynomial parameter. The algorithm is the classical one and calls a .multiply method that multiplies a monomial with a Polynomial object together with the .subtract method.
    -	.derivate() performs the derivation term by term and returns the result.
    -	.integrate() performs the integration term by term and returns the result.   

- Patterns
This class is used to store the RegEx that I am looking for in the string.

    - No methods are instantiated here.

- Pair
A utility class that uses 2 generics as parameters. Stores pairs of (Integer, Double) in most cases. 

    - Only setters and getters.

- MainFrame
The underlying canvas of all the GUI. All panels are stamped on top of it.

    - The methods set up the basic functionalities: when exited the application stops as well, the window is not resizable and is displayed. .setPaneUI() places the two panels where objects that support interaction with the user are placed.

- InputPanel
Acts as a frame for other two panels.

    - The methods set up the size and place the ReadPanel and the OutputPanel inside.

-	ReadPanel
It is composed of two JTextFields that are used for inserting polynomials as input. 

     - The methods specify the placement. Some getters are required.	

-	OutputPanel
Its main purpose is to house the JTextArea that serves as an output field for the resulting computation.

     - The methods set the appearance and position inside the InputPanel. A specific method .refreshPanel() updates the output value based on the computational result.

-	CalcPanel
This panel houses the buttons that correspond to the mathematical operations that can be performed on polynomials: addition, subtraction, multiplication, division, derivation, and integration.

     - The methods place the buttons in a symmetric manner based on a GridBagLayout and a vector of coordinates.

-	MyActionListener
The class implements the ActionListener interface and makes the connection between user’s interaction and the feedback of the application and the GUI. It stores references to the OutputPanel, the ReadPanel and the operation corresponding to the button.

    -	.getInputPoly(JTextField textField) is called when a button is pressed. It also sends a control to the OutputPanel to signal it to update.
    -	.performCalc() is the method that decides which button has been pressed and what operation should be performed. Depending on that either one or both JTextFields are saved and converted into Polynomial-type objects. The requested operation is performed afterwards.  


## 5. Results

All the mathematical functionalities have been tested and compared to human-computed results, double-checked by means of Microsoft web calculator. I aimed to take into consideration all critical cases such as multiplying by 0, integrating 0, dividing by 0 etc. I did not notice any erroneous computations for additions, subtractions, multiplications, integrations, or derivations. The only error I discovered in testing is caused by division, but I believe it is insignificant: when dividing polynomials whose division of coefficients generates irrational numbers (i.e. 2/3=0.66666… ) the representation in memory is, of course, truncated. This means the more operations the computer performs with this type of number the bigger the error becomes. In my test, after about three divisions and three multiplications (involving division by 13, 169 etc.) the error appeared to be in the range of ±3 in the order of the 16th digit (computationally speaking, this is a great and irrelevant approximation).

The tests and their results are discussed in depth in the Documentation. See [Section 5 - "Results" here.](/Documentation.pdf)

## 6. Conclusions

Working on this assignment felt great after two weeks of not keeping in touch with Java. The task itself was not that complex, but there were a lot of small things to keep track of. The real challenge was to break down the calculator itself into independent modules that can perform more general tasks or are (more or less) open to extension while keeping it simple and clear. I did not have a lot of fun while creating the graphical user interface, but, in the end, I feel like I am more aware of what layouts can do, how action listeners are supposed to be designed or how frames and panels interact. I practiced the decomposition of classes into subclasses and aimed the design short and effective methods that are more Java-like than C.
	The final application is not the best it can be for sure. I consider its main defects to be the graphical user interface and the input-output polynomial representation. The GUI is simple and does its job, but it does not make anyone want to try or spend more time than needed with the application running. Its roughness is not a point of focus for a software engineer, but if it were to be used by any other people but engineers, no one would consider the way it looks appealing. It does compute correctly, though. At the same time, I hate the way I must insert polynomials as strings because I feel like I lose a lot of time searching for ^ or pressing shift + x for a capital letter. This input method should be optimized. The way the result is shown at output is not pleasant, as well. It seems too hard to follow even for me. 
	Other further developments:
-	Improved GUI.
-	Improved class design.
-	Improved and simplified inter-class connections.
-	Improved, simplified, and more specialized intra-class connections.
-	New operations: negation & multiplying by a monomial (already implemented as private for subtraction), rising to a power, evaluation at a certain X value. 
-	Perfectioning the division operation so that it prints a polynomial in fractional form rather than decimal for superior precision.
-	Cleaner, more explicit code style.

## 7. References
-	[Unified Modeling Language](https://en.wikipedia.org/wiki/Unified_Modeling_Language)
-	[Use Case Diagrams | Unified Modeling Language (UML)](https://www.geeksforgeeks.org/use-case-diagram/)
- [Draw.io](https://app.diagrams.net/)
-	[Use Case Diagram Tutorial](https://creately.com/guides/use-case-diagram-tutorial/)
-	[RegExr: Learn, Build, & Test RegEx](https://regexr.com/)
-	[regex101: build, test, and debug regex](https://regex101.com/)
-	[Regular expression - Wikipedia](https://en.wikipedia.org/wiki/Regular_expression)
-	[StackOverflow](https://stackoverflow.com/questions/2420742/make-a-jlabel-wrap-its-text-by-setting-a-max-width)
-	[A Guide to JUnit 5](https://www.baeldung.com/junit-5)
-	[Polynomial Equation Calculator](https://www.symbolab.com/solver/polynomial-equation-calculator)
-	[A Visual Guide to Layout Managers](https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#border)
-	[Microsoft Math Solver](https://mathsolver.microsoft.com/en/solve-problem/)
-	[Programming Techniques lectures, laboratories, and support materials](https://dsrl.eu/)
-	Paul Deitel, Harvey Deitel, Java How to program (10th edition), Publisher: Pearson Education, Inc., Upper Saddle River, NJ, United States, ISBN: 978-0-13-380780-6, Published: 2015
-	Ștefan Tanasă, Ștefan Andrei, Cristian Olaru, Java: de la 0 la expert (2nd edition), Publisher: Polirom, Iași, Romania, ISBN: 978-973-46-2405-8, Published: 2011

