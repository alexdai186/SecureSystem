UTEID: amd4482; scw2243;
FIRSTNAME: Alexander; Songting
LASTNAME: Dai; Wu;
CSACCOUNT: alexdai; cindywu;
EMAIL: alexdai@utexas.edu; cindywu2018@utexas.edu;

[Program 1]
[Description]
......

[Finish]
Finished all requirements

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

[Input of test 5]
import static org.junit.Assert.*;
import org.junit.Test;

public class SecureSystemTest {

    @Test
    public void test_parseArgs1(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"write", "hal", "lyle", "10"};
        assertEquals("write", sys.parseArgs(args).getInstructionType().getValue());
        assertEquals("hal", sys.parseArgs(args).getSubjectName());
        assertEquals("lyle", sys.parseArgs(args).getObjectName());
        assertEquals(10, sys.parseArgs(args).getValue());
    }

    @Test
    public void test_parseArgs2(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"write", "hal", "lyle", "hello"};
        assertEquals(InstructionType.BAD, sys.parseArgs(args).getInstructionType());
    }

    @Test
    public void test_parseArgs3(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read", "hal8", "lyle"};
        assertEquals("read", sys.parseArgs(args).getInstructionType().getValue());
        assertEquals("hal8", sys.parseArgs(args).getSubjectName());
        assertEquals("lyle", sys.parseArgs(args).getObjectName());
    }

    @Test
    public void test_parseArgs4(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read"};
        assertEquals(InstructionType.BAD, sys.parseArgs(args).getInstructionType());
    }

    @Test
    public void test_parseArgs5(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read", "read", "read", "read"};
        assertEquals(InstructionType.BAD, sys.parseArgs(args).getInstructionType());
    }

    @Test
    public void test_parseArgs6(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"hi", "hi", "hi"};
        assertEquals(InstructionType.BAD, sys.parseArgs(args).getInstructionType());
    }

    @Test
    public void test_parseArgs7(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"Write", "hi", "bye", "40"};
        assertEquals(40, sys.parseArgs(args).getValue());
    }

}

[Output of test 5]
Passed
Passed
Passed
Passed
Passed
Passed
Passed
