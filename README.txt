UTEID: amd4482; scw2243;
FIRSTNAME: Alexander; Songting
LASTNAME: Dai; Wu;
CSACCOUNT: alexdai; cindywu;
EMAIL: alexdai@utexas.edu; cindywu2018@utexas.edu;

[Program 1]
[Description]
......

[Finish]
......

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

[Output of test 2]

[Input of test 3]

[Output of test 3]

[Input of test 4]

[Output of test 4]