import java.util.ArrayList;

/**
 * Created by Alex Dai on 2/7/2017.
 */


/* S_Object Object */
// Documentation suggests we do this in ReferenceMonitor Class
class S_Object {
    String name;
    String security_level;
    int temp = 0;

    public S_Object(String n, String s, int t){
        name = n;
        security_level = s;
        temp = t;
    }

    public void setTemp(int t){
        temp = t;
    }
}


public class ReferenceMonitor {

    ArrayList<S_Object> obj_list;
    public ReferenceMonitor(){
        obj_list = new ArrayList<>();
    }
    public void createObject(String name, String security_level) {
        /* Possible issue with object names? */
        S_Object temp = new S_Object(name, security_level, 0);
        obj_list.add(temp);
    }

    public ArrayList<S_Object> getObjects() {
        return obj_list;
    }
}
