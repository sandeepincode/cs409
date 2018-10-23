# java-parser-code-smells
<p>
Using the visitor design pattern to implement code smell detection.
The main implementation pulls relevant information from the AST and runs the 
valuidation tests within the TestSuite.java file.
</p>
<p>
Things it can detect are:
<ul>
<li>Long parameter list</li>
<li>Long method - Statement counts</li>
<li>Long class - Statement counts</li>
<li>Message Chain</li>
<li>Primitive Obsession</li>
<li>Data Clumps</li>
<li>Lazy Class</li>
<li>Data Class</li>
</ul>
</p>
<p>
Are they detected accurately? Probably not, however have a poke at the InpectClass and InspectMethod 
files if you want to change and limit values. Ultimately, this was a university assigment where I went 
a bit over kill on the design but HEY! its a software engineering course. Anyways, we where graded on our
use of Java Parser, which is funny since we are in a software architecture. That logic tho,
</p>
Over and out from your !(caped crusader),
<br>
- sandeepincode
