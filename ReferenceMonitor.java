import java.util.ArrayList;
public class ReferenceMonitor {

    private ArrayList<S_Object> obj_list;

    public ReferenceMonitor() {
        obj_list = new ArrayList<>();
    }
    public void createObject(String name, SecurityLevel level) {
        S_Object temp = new S_Object(name, level);
        obj_list.add(temp);
    }
    public ArrayList<S_Object> getObjects() {
        return obj_list;
    }

    class S_Object {
        private String name;
        private String securityLevel;
        private int temp = 0;

        public S_Object(String n, SecurityLevel level) {
            name = n;
            securityLevel = s;
        }

        public void setTemp(int t){
            temp = t;
        }
    }
}
