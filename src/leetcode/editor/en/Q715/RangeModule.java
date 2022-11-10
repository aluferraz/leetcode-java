package leetcode.editor.en.Q715;

import java.util.*;

//A Range Module is a module that tracks ranges of numbers. Design a data 
//structure to track the ranges represented as half-open intervals and query about them.
// 
//
// A half-open interval [left, right) denotes all the real numbers x where left 
//<= x < right. 
//
// Implement the RangeModule class: 
//
// 
// RangeModule() Initializes the object of the data structure. 
// void addRange(int left, int right) Adds the half-open interval [left, right),
// tracking every real number in that interval. Adding an interval that partially 
//overlaps with currently tracked numbers should add any numbers in the interval [
//left, right) that are not already tracked. 
// boolean queryRange(int left, int right) Returns true if every real number in 
//the interval [left, right) is currently being tracked, and false otherwise. 
// void removeRange(int left, int right) Stops tracking every real number 
//currently being tracked in the half-open interval [left, right). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", 
//"queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//Output
//[null, null, null, true, false, true]
//
//Explanation
//RangeModule rangeModule = new RangeModule();
//rangeModule.addRange(10, 20);
//rangeModule.removeRange(14, 16);
//rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is 
//being tracked)
//rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17
// in [13, 15) are not being tracked)
//rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is 
//still being tracked, despite the remove operation)
// 
//
// 
// Constraints: 
//
// 
// 1 <= left < right <= 10⁹ 
// At most 10⁴ calls will be made to addRange, queryRange, and removeRange. 
// 
//
// 👍 1158 👎 93


//leetcode submit region begin(Prohibit modification and deletion)

public class RangeModule {


    public RangeModule() {

    }

    public void addRange(int left, int right) {
    }

    public boolean queryRange(int left, int right) {
        return false;
    }

    public void removeRange(int left, int right) {
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 * <p>
 * class BSTNode {
 * public int lo;
 * public int hi;
 * private int hiRooted;
 * public BSTNode left;
 * public BSTNode right;
 * <p>
 * public BSTNode(int lo, int hi) {
 * this.lo = lo;
 * this.hi = hi;
 * this.hiRooted = hi;
 * }
 * <p>
 * public int getHiRooted() {
 * return hiRooted;
 * }
 * <p>
 * public void setHiRooted(int hiRooted) {
 * this.hiRooted = hiRooted;
 * }
 * }
 * <p>
 * class BinarySearchTree {
 * BSTNode root;
 * <p>
 * public BinarySearchTree() {
 * <p>
 * }
 * <p>
 * public void insert(BSTNode nodeToInsert) {
 * if (this.root == null) {
 * this.root = nodeToInsert;
 * return;
 * }
 * this.insertHelper(this.root, nodeToInsert);
 * }
 * <p>
 * private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 * if (nodeToInsert.lo < node.lo) {
 * if (node.left == null) {
 * node.left = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 * return node.hiRooted;
 * }
 * if (node.right == null) {
 * node.right = nodeToInsert;
 * node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 * return node.hiRooted;
 * }
 * node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 * return node.hiRooted;
 * }
 * <p>
 * public BSTNode findNode(BSTNode from, int lo, int hi) {
 * if (from == null) return null;
 * if (lo < from.lo) return findNode(from.left, lo, hi);
 * if (lo > from.lo) return findNode(from.right, lo, hi);
 * if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 * return from;
 * }
 * <p>
 * public void delete(int lo, int hi) {
 * BSTNode target = findNode(this.root, lo, hi);
 * if (target == null) return;
 * if (target.left != null && target.right == null) {
 * BSTNode left = target.left.left;
 * BSTNode right = target.left.right;
 * target.lo = target.left.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * if (target.right != null && target.left == null) {
 * BSTNode left = target.right.left;
 * BSTNode right = target.right.right;
 * target.lo = target.right.lo;
 * target.left = left;
 * target.right = right;
 * return;
 * }
 * BSTNode leftmostChild = null;
 * BSTNode current = target.right;
 * while (current.left != null) {
 * current = current.left;
 * }
 * leftmostChild = current;
 * int newLo = leftmostChild.lo;
 * delete(leftmostChild.lo, leftmostChild.hi);
 * target.lo = newLo;
 * }
 * <p>
 * public boolean queryRange(int lo, int hi) {
 * return queryRangeHelper(this.root, lo, hi);
 * <p>
 * }
 * <p>
 * private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 * if (from == null) return false;
 * if (from.lo >= lo && hi <= from.hiRooted) return true;
 * if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 * if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 * return false;
 * }
 * <p>
 * }
 * <p>
 * public BinarySearchTree BST;
 */
//leetcode submit region end(Prohibit modification and deletion)

/**
 *     class BSTNode {
 *         public int lo;
 *         public int hi;
 *         private int hiRooted;
 *         public BSTNode left;
 *         public BSTNode right;
 *
 *         public BSTNode(int lo, int hi) {
 *             this.lo = lo;
 *             this.hi = hi;
 *             this.hiRooted = hi;
 *         }
 *
 *         public int getHiRooted() {
 *             return hiRooted;
 *         }
 *
 *         public void setHiRooted(int hiRooted) {
 *             this.hiRooted = hiRooted;
 *         }
 *     }
 *
 *     class BinarySearchTree {
 *         BSTNode root;
 *
 *         public BinarySearchTree() {
 *
 *         }
 *
 *         public void insert(BSTNode nodeToInsert) {
 *             if (this.root == null) {
 *                 this.root = nodeToInsert;
 *                 return;
 *             }
 *             this.insertHelper(this.root, nodeToInsert);
 *         }
 *
 *         private int insertHelper(BSTNode node, BSTNode nodeToInsert) {
 *             if (nodeToInsert.lo < node.lo) {
 *                 if (node.left == null) {
 *                     node.left = nodeToInsert;
 *                     node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 *                     return node.hiRooted;
 *                 }
 *                 node.hiRooted = Math.max(node.hiRooted, insertHelper(node.left, nodeToInsert));
 *                 return node.hiRooted;
 *             }
 *             if (node.right == null) {
 *                 node.right = nodeToInsert;
 *                 node.hiRooted = Math.max(node.hiRooted, nodeToInsert.hi);
 *                 return node.hiRooted;
 *             }
 *             node.hiRooted = Math.max(node.hiRooted, insertHelper(node.right, nodeToInsert));
 *             return node.hiRooted;
 *         }
 *
 *         public BSTNode findNode(BSTNode from, int lo, int hi) {
 *             if (from == null) return null;
 *             if (lo < from.lo) return findNode(from.left, lo, hi);
 *             if (lo > from.lo) return findNode(from.right, lo, hi);
 *             if (from.hi != hi) return findNode(from.right, lo, hi); //When lo is equal, we place it to right
 *             return from;
 *         }
 *
 *         public void delete(int lo, int hi) {
 *             BSTNode target = findNode(this.root, lo, hi);
 *             if (target == null) return;
 *             if (target.left != null && target.right == null) {
 *                 BSTNode left = target.left.left;
 *                 BSTNode right = target.left.right;
 *                 target.lo = target.left.lo;
 *                 target.left = left;
 *                 target.right = right;
 *                 return;
 *             }
 *             if (target.right != null && target.left == null) {
 *                 BSTNode left = target.right.left;
 *                 BSTNode right = target.right.right;
 *                 target.lo = target.right.lo;
 *                 target.left = left;
 *                 target.right = right;
 *                 return;
 *             }
 *             BSTNode leftmostChild = null;
 *             BSTNode current = target.right;
 *             while (current.left != null) {
 *                 current = current.left;
 *             }
 *             leftmostChild = current;
 *             int newLo = leftmostChild.lo;
 *             delete(leftmostChild.lo, leftmostChild.hi);
 *             target.lo = newLo;
 *         }
 *
 *         public boolean queryRange(int lo, int hi) {
 *             return queryRangeHelper(this.root, lo, hi);
 *
 *         }
 *
 *         private boolean queryRangeHelper(BSTNode from, int lo, int hi) {
 *             if (from == null) return false;
 *             if (from.lo >= lo && hi <= from.hiRooted) return true;
 *             if (lo < from.lo) return queryRangeHelper(from.left, lo, hi);
 *             if (lo > from.lo) return queryRangeHelper(from.right, lo, hi);
 *             return false;
 *         }
 *
 *     }
 *
 *     public BinarySearchTree BST;
 */