**xml calculus**

Brief:

App should accept as input .xml file with below structure:

```
<input>
    <value a=„1” b=„3”/>
    <value a=„2” b=„4”/>
<!– itd-->
</input>
```
UI should contain operation selection (multiplication, division, addition and subtraction),

UI should contain number of operation cycle to be performed as user input, 

After "run" button is pressed application should perform selected operation requested number of times replacing the "b" value in each cycle for the resul of the previous one;

Example:
```
A = 4, B = 3, operation = multiplication, number of operations = 3
4 * 3 = 12
4 * 12 = 48
4 * 48 = 192
```

Result of each cycle should be displayed to user.

**to run it**
Download jar from here:

XML_calculus/out/artifacts/WinForms_jar/WinForms.jar
and run it using:
```
java -jar WinForms.jar
```
you can also use this xml for tests:

XML_calculus/src/main/resources/new.xml
 :rocket:
