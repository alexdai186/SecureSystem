/**
 * Created by Alex Dai on 2/5/2017.
 */
import java.lang.String;
import java.lang.Integer;

class InstructionObject{
    String command;
    String subject;
    String object;
    int value;
    public InstructionObject(){}
}

public class SecureSystem {

    public static void main(String[] args){

        parseArgs(args);

    }

    static public InstructionObject parseArgs(String[] args){
        //Checks len of arguments
        InstructionObject bad = new InstructionObject();
        bad.command = "bad";
        if (args.length < 3 || args.length > 4){
            return bad;
        }

        InstructionObject ins = new InstructionObject();
        /* Sets the Command */
        String command = args[0].toLowerCase();
        switch (command){
            case "read":
                ins.command = "read";
                break;
            case "write":
                ins.command = "write";
            default:
                return bad;
        }
        ins.subject = args[1].toLowerCase();
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
