

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class InventoryMain {
    public static void main(String[] args){
        InvView view = new InvView();
        InvModel model = new InvModel();
        InvController controller = new InvController(view, model);
        model.addObserver(view);
        
    }
}
