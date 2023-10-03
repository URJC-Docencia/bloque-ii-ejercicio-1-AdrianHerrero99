
import material.Position;

import java.util.Iterator;


/**
 * This class represents a tree data structure using a linked implementation.
 * It implements the NAryTree interface.
 *
 * @param <E> the type of element stored in the tree
 */
public class LinkedTree<E> implements NAryTree<E> {

    /**
     * This class represents a node in a tree data structure.
     * It implements the Position interface.
     *
     * @param <T> the type of element stored in the node
     */
    private class TreeNode<T> implements Position<T> {
        private List<TreeNode<T>> children = new ArrayList<>();;
        private TreeNode<T> parent;
        private T element;
        
        public TreeNode(T element){
            this.element=element;
        }

        public TreeNode(T element, TreeNode<T> parent){
            this.element=element;
            this.parent=parent;
        }
        
        @Override
        public T getElement() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    private TreeNode<E> root;
    private int size;

    @Override
    public Position<E> addRoot(E e) {
        if(!isEmpty()){
            throw_new_RuntimeException("The tree has already a root node");
        }
        root=new TreeNode<>(e);
        return root;
        
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> parent=checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(element,parent);
        parent.getChildren().add(newNode);
        size++;
        return newNode;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        TreeNode<E> parent=checkPosition(p);
        checkPositionOfChildrenList(n,parent);
        TreeNode<E> newNode = new TreeNode<>(element,parent);
        parent.getChildren().add(newNode);
        size++;
        return newNode;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        
    }

    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = checkPosition(p);
        E old = node.getElement();
        node.element=e;
        return old;
    }

    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        if(node==root){
            root=null;
            size=0;
        }
        else{
            TreeNode<E> parent = node.getparent();
            parent.getChildren().remove(node);
            size-=computeSize(node);
        }
        return size;
        
    }

    private int computeSize(TreeNode<E> node){
        int size = 1;
        for(TreeNode<E> child : node.getChildren()){
            size+= computeSize(child);
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        LinkedTree<E> tree = new LinkedTree<>();
        this.root= 
        
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Position<E> root() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Position<E> parent(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isRoot(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<Position<E>> iterator() {
        //comprobar si esta vacio
        List<Position<E>> positions = new ArrayList<>();
        breadthOrder(root, positions;
        return positions.iterator();
        
    }

    private void breadth(TreeNode<E> root, List<Position<E>> positions){
            if(root!= null){
                List<TrreNode> queu = new ArrayList<>();
                queu.add(node);
                while(!queu.isEmpty()){
                    TreeNode<E> toExplore = queu.remove(index:0);
                    positions.add(toExplore);
                    queu.addAll(node.getChildren());
                }

            }

    }

    public int size() {
        return size;
    }
}
