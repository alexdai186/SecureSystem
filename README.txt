UTEID: amd4482; scw2243;
FIRSTNAME: Alexander; Songting
LASTNAME: Dai; Wu;
CSACCOUNT: alexdai; cindywu;
EMAIL: alexdai@utexas.edu; cindywu2018@utexas.edu;

[Program 1]
[Description]
This program stimulates a simple secure system that follows the Bell and LaPadula rules, in which subjects can perform read and write instructions on objects, as long as the instructions are syntactically correct and the subjects have the clearance to do so. The input to the program is a file with lines of instructions, and the output is a display of the system state, printing current values of all the objects and values that all the subjects had recently read after each instruction. The most important file is SecureSystem.java, which has the main method, parseArgs(), and printState(). The main method creates all objects and subjects in the system, reads in the instructions and executes them according to BLP rules, finally printing the system state after each instruction it reads. We check for instruction syntax in the method parseArgs() that takes in a line of instruction and passes to the Reference Monitor either an InstructionObject for a syntactically correct read/write or a BadInstruction for an illegal instruction. To implement security, the Reference Monitor uses the method execute() that calls either executeRead() or executeWrite() for legal instructions in which subjects have the appropriate security level to access objects. If the subject does not have clearance, no action is done. After the firewall (ReferenceMonitor) filters out authorized access, the actual read() and write() is performed by ObjectManager, which is local to ReferenceMonitor so all the read/write are legal. Finally, when the instruction is executed (or not executed), the system state is printed to reflect current values in all subjects and objects. In addition, it is important to note that we have a SecuritySystemTest.java, in which we wrote 7 unit tests to make sure that our parseArgs() works as expected.

[Finish]
We finished all of the assignment and met all the requirements. Our test case output matches exactly with professor's output. Therefore, everything should work fine.

[Test Cases]
[Input of test 1]
write hal hobj 
read hal 
write lyle lobj 10
read hal lobj 
write lyle hobj 20
write hal lobj 200
read hal hobj
read lyle lobj
read lyle hobj
foo lyle lobj
Hi lyle, This is hal
The missile launch code is 1234567

[Output of test 1]
Reading from file: instructionList

Bad Instruction
The current state is: 
   lobj has value: 0
   hobj has value: 0
   lyle has recently read: 0
   hal has recently read: 0

Bad Instruction
The current state is: 
   lobj has value: 0
   hobj has value: 0
   lyle has recently read: 0
   hal has recently read: 0

lyle writes value 10 to lobj
The current state is: 
   lobj has value: 10
   hobj has value: 0
   lyle has recently read: 0
   hal has recently read: 0

hal reads lobj
The current state is: 
   lobj has value: 10
   hobj has value: 0
   lyle has recently read: 0
   hal has recently read: 10

lyle writes value 20 to hobj
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 10

hal writes value 200 to lobj
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 10

hal reads hobj
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 20

lyle reads lobj
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 10
   hal has recently read: 20

lyle reads hobj
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 20

Bad Instruction
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 20

Bad Instruction
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 20

Bad Instruction
The current state is: 
   lobj has value: 10
   hobj has value: 20
   lyle has recently read: 0
   hal has recently read: 20
   
[Input of test 2]
write hal hal 10
read hal hal
read lobj lobj
read lobj hal
read hal lobj 10

[Output of test 2]
Reading from file: testInstructions2

Bad Instruction
hal writes value 10 to hal
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
hal reads hal
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
lobj reads lobj
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
lobj reads hal
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

[Input of test 3]
write hal hobj -1
alex's social security number is
5 3 4 2 5 3
write         hal hobj 4
write lyle lobj 344
read            lyle                           lobj

[Output of test 3]
Reading from file: testInstructions3

hal writes value -1 to hobj
The current state is:
	lobj has value: 0
	hobj has value: -1
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: -1
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: -1
	lyle has recently read: 0
	hal has recently read: 0

hal writes value 4 to hobj
The current state is:
	lobj has value: 0
	hobj has value: 4
	lyle has recently read: 0
	hal has recently read: 0

lyle writes value 344 to lobj
The current state is:
	lobj has value: 344
	hobj has value: 4
	lyle has recently read: 0
	hal has recently read: 0

lyle reads lobj
The current state is:
	lobj has value: 344
	hobj has value: 4
	lyle has recently read: 344
	hal has recently read: 0

[Input of test 4]
write hal hobj    4   .    5
read h al hobj -3.4
read hal lobj
write hal hobj     .
read hal lobj                                  ke

[Output of test 4]
Reading from file: testInstructions4

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

hal reads lobj
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0
	