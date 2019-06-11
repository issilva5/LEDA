package adt.rbtree;

import java.util.ArrayList;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements RBTree<T> {

   public RBTreeImpl() {
      this.root = new RBNode<T>();
   }

   public RBNode<T> getRBRoot() {

      return (RBNode<T>) this.root;

   }

   private RBNode<T> getNodeRight(BSTNode<T> node) {

      return (RBNode<T>) node.getRight();

   }

   private RBNode<T> getNodeLeft(BSTNode<T> node) {

      return (RBNode<T>) node.getLeft();

   }

   private RBNode<T> getNodeParent(BSTNode<T> node) {

      return (RBNode<T>) node.getParent();

   }

   private RBNode<T> getNodeGrand(BSTNode<T> node) {

      RBNode<T> grand = null;

      if (node.getParent() != null) {

         if (node.getParent().getParent() != null) {

            grand = (RBNode<T>) node.getParent().getParent();

         }

      }

      return grand;

   }

   private RBNode<T> getNodeUncle(BSTNode<T> node) {

      RBNode<T> uncle = null;
      RBNode<T> grand = this.getNodeGrand(node);

      if (grand != null) {

         if (this.nodeSide(this.getNodeParent(node)) == -1) {

            uncle = this.getNodeRight(grand);

         } else {

            uncle = this.getNodeLeft(grand);

         }

      }

      return uncle;

   }

   protected int blackHeight() {

      return this.blackHeight(this.getRBRoot());

   }

   private int blackHeight(RBNode<T> node) {

      int height = 1;

      if (node != null && !node.isEmpty()) {

         if (node.getColour() == Colour.RED) {

            height = 0;

         }

         height += Math.max(this.blackHeight(this.getNodeLeft(node)), this.blackHeight(this.getNodeRight(node)));

      }

      return height;
   }

   protected boolean verifyProperties() {

      boolean resp = verifyNodesColour() && verifyNILNodeColour() && verifyRootColour() && verifyChildrenOfRedNodes()
            && verifyBlackHeight();

      return resp;
   }

   /**
    * The colour of each node of a RB tree is black or red. This is guaranteed
    * by the type Colour.
    */
   private boolean verifyNodesColour() {
      return true; // already implemented
   }

   /**
    * The colour of the root must be black.
    */
   private boolean verifyRootColour() {
      return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
      // implemented
   }

   /**
    * This is guaranteed by the constructor.
    */
   private boolean verifyNILNodeColour() {
      return true; // already implemented
   }

   /**
    * Verifies the property for all RED nodes: the children of a red node must
    * be BLACK.
    */
   private boolean verifyChildrenOfRedNodes() {

      return this.verifyChildrenOfRedNodes(this.getRBRoot());

   }

   private boolean verifyChildrenOfRedNodes(RBNode<T> node) {

      boolean verified = true;

      if (node != null && !node.isEmpty() && node.getColour() == Colour.RED) {

         verified = this.getNodeLeft(node).getColour() == Colour.BLACK
               && this.getNodeRight(node).getColour() == Colour.BLACK;

      }

      if (!node.isEmpty() && (node.getColour() == Colour.BLACK || verified)) {

         verified = this.verifyChildrenOfRedNodes(this.getNodeLeft(node))
               && this.verifyChildrenOfRedNodes(this.getNodeRight(node));

      }

      return verified;

   }

   /**
    * Verifies the black-height property from the root.
    */
   private boolean verifyBlackHeight() {

      return this.verifyBlackHeight(this.getRBRoot());

   }

   private boolean verifyBlackHeight(RBNode<T> node) {

      boolean verified = node.isEmpty()
            || (this.blackHeight(this.getNodeLeft(node)) == this.blackHeight(this.getNodeRight(node)));

      if (!node.isEmpty() && verified) {

         verified = this.verifyBlackHeight(this.getNodeLeft(node)) && this.verifyBlackHeight(this.getNodeRight(node));

      }

      return verified;

   }

   @Override
   public void insert(T value) {

      RBNode<T> newNode = this.insert(value, this.getRBRoot());
      this.fixUpCase1(newNode);

   }

   private RBNode<T> insert(T value, RBNode<T> node) {

      RBNode<T> returnValue = null;

      if (node.isEmpty()) {

         node.setData(value);
         node.setColour(Colour.RED);
         node.setLeft(new RBNode<>());
         node.getLeft().setParent(node);
         node.setRight(new RBNode<>());
         node.getRight().setParent(node);
         returnValue = node;

      } else {

         if (node.getData().compareTo(value) > 0) {

            returnValue = this.insert(value, this.getNodeLeft(node));

         } else {

            returnValue = this.insert(value, this.getNodeRight(node));

         }

      }

      return returnValue;

   }

   @Override
   public RBNode<T>[] rbPreOrder() {

      ArrayList<RBNode<T>> array = new ArrayList<>();

      if (!this.isEmpty()) {

         this.rbPreOrder(this.getRBRoot(), array);

      }

      return array.toArray(new RBNode[this.size()]);

   }

   private void rbPreOrder(RBNode<T> node, ArrayList<RBNode<T>> array) {

      if (!node.isEmpty()) {

         array.add(node);

         this.rbPreOrder(this.getNodeLeft(node), array);
         this.rbPreOrder(this.getNodeRight(node), array);

      }

   }

   // FIXUP methods
   protected void fixUpCase1(RBNode<T> node) {

      if (node.equals(this.getRBRoot())) {

         node.setColour(Colour.BLACK);

      } else {

         this.fixUpCase2(node);

      }

   }

   protected void fixUpCase2(RBNode<T> node) {

      if (this.getNodeParent(node).getColour() != Colour.BLACK) {

         this.fixUpCase3(node);

      }

   }

   protected void fixUpCase3(RBNode<T> node) {

      RBNode<T> grandParent = this.getNodeGrand(node);
      RBNode<T> uncle = this.getNodeUncle(node);

      if (uncle.getColour() == Colour.RED) {

         grandParent.setColour(Colour.RED);
         uncle.setColour(Colour.BLACK);
         this.getNodeParent(node).setColour(Colour.BLACK);

         this.fixUpCase1(grandParent);

      } else {

         this.fixUpCase4(node);

      }

   }

   protected void fixUpCase4(RBNode<T> node) {

      RBNode<T> next = node;
      RBNode<T> parent = this.getNodeParent(node);

      if (this.nodeSide(node) == 1 && this.nodeSide(parent) == -1) {

         this.leftRotation(parent);

         next = this.getNodeLeft(node);

      } else if (this.nodeSide(node) == -1 && this.nodeSide(parent) == 1) {

         this.rightRotation(parent);

         next = this.getNodeRight(node);

      }

      this.fixUpCase5(next);

   }

   private int nodeSide(RBNode<T> node) {

      int side = 0;

      if (node.getParent() != null) {

         if (node.getData().compareTo(node.getParent().getData()) < 0) {

            side--;

         } else {

            side++;

         }

      }

      return side;
   }

   protected void fixUpCase5(RBNode<T> node) {

      RBNode<T> parent = this.getNodeParent(node);
      RBNode<T> grandParent = this.getNodeGrand(node);

      parent.setColour(Colour.BLACK);
      grandParent.setColour(Colour.RED);

      if (this.nodeSide(node) == -1) {

         this.rightRotation(grandParent);

      } else {

         this.leftRotation(grandParent);

      }

   }

   protected void leftRotation(BSTNode<T> node) {
      BSTNode<T> newNode = Util.leftRotation(node);
      if (newNode.getParent() == null) {
         this.root = newNode;
      }
   }

   protected void rightRotation(BSTNode<T> node) {
      BSTNode<T> newNode = Util.rightRotation(node);
      if (newNode.getParent() == null) {
         this.root = newNode;
      }
   }

}
