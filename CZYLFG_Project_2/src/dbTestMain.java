/**
 *
 * @author kisoo
 */
public class dbTestMain {
    public static void main(String[] args){
        InvView view = new InvView();
        InvModel model = new InvModel();
        InvController controller = new InvController(view, model);
        model.addObserver(view);
        
//        InvDBManager db = new InvDBManager();
    }
}
