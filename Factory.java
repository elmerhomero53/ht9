/**
 * Marco Ramirez
 * Jose Ramos
 * 
 */
import java.util.PriorityQueue;

class Factory {
	/**
	 * 
	 */
    public Factory(){}
    Object tree;
    /**
     * 
     * @param imp
     * @return
     */
    public Object getImp(String imp) {
    // Implementaciones
        if(imp.equals("SplayTree"))
        {   
            tree = new SplayTree<>();
        }else{
            tree = new RedBlackBST<>();
        } 
        return tree;
   }

}
