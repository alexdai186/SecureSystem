import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Alex Dai on 2/7/2017.
 */
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