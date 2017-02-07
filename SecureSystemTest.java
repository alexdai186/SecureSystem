import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by Alex Dai on 2/6/2017.
 */
public class SecureSystemTest {

    public void test_parseArgs1(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"write", "hal", "lyle", "10"};
        assertEquals("write", sys.parseArgs(args).getInstructionType().getValue());
        assertEquals("hal", sys.parseArgs(args).getSubject());
        assertEquals("lyle", sys.parseArgs(args).getObject());
        assertEquals(10, sys.parseArgs(args).getValue());
    }

    public void test_parseArgs2(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"write", "hal", "lyle", "hello"};
        assertEquals("bad", sys.parseArgs(args).getInstructionType().getValue());
    }

    public void test_parseArgs3(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read", "hal8", "lyle"};
        assertEquals("read", sys.parseArgs(args).getInstructionType().getValue());
        assertEquals("hal8", sys.parseArgs(args).getSubject());
        assertEquals("lyle", sys.parseArgs(args).getObject());
    }

    public void test_parseArgs4(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read"};
        assertEquals("bad", sys.parseArgs(args).getInstructionType().getValue());
    }

    public void test_parseArgs5(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"read", "read", "read", "read"};
        assertEquals("bad", sys.parseArgs(args).getInstructionType().getValue());
    }

    public void test_parseArgs6(){
        SecureSystem sys = new SecureSystem();
        String[] args = {"hi", "hi", "hi"};
        assertEquals("bad", sys.parseArgs(args).getInstructionType().getValue());
    }
}