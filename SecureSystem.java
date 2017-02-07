/**
 * Created by Alex Dai on 2/5/2017.
 */
import java.lang.String;
import java.lang.Integer;


/* Instruction Object */
class InstructionObject {
    String command;
    S_Subject subject;
    S_Object object;
    int value;

    public InstructionObject(){}
}

/* S_Subject Object */
class S_Subject {
    String name;
    String security_level;

    public S_Subject(){}
}

/* S_Object Object */
// Documentation suggests we do this in ReferenceMonitor Class
class S_Object {
    String name;
    String security_level;

    public S_Object(){}
}

public class SecureSystem {

    public static void main(String[] args){

        S_Subject hal = new S_Subject();
        hal.name = "hal";
        hal.security_level = "HIGH";

        S_Subject lyle = new S_Subject();
        lyle.name = "lyle";
        lyle.security_level = "LOW";



        parseArgs(args);

    }

    static public InstructionObject parseArgs(String[] args){
        InstructionObject bad = new InstructionObject();
        bad.command = "bad";
        /* Returns BadInstruction if invalid number of arguments */
        if (args.length < 3 || args.length > 4)
            return bad;

        /* Sets the Command for Instruction*/
        String command = args[0].toLowerCase();
        InstructionObject ins = new InstructionObject();
        switch (command){
            case "read":
                ins.command = "read";
                break;
            case "write":
                ins.command = "write";
            default:
                return bad;
        }

        /* Sets User and Target for Instruction */
        String arg1 = args[1].toLowerCase();
        String arg2 = args[2].toLowerCase();
        if (arg1.equals("lyle") || arg1.equals("hal")){
            ins.subject = arg1;
        }
        ins.object = args[2].toLowerCase();

        if (args.length > 3){
            try{
                ins.value = Integer.parseInt(args[3]);
            }
            catch(Exception e){
                return bad;
            }
        }

        return ins;
    }
}
