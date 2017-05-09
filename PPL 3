package lazyTrees;
import cs_1c.Traverser;

import java.util.*;


public class LazySearchTree<E extends Comparable< ? super E >>implements Cloneable
{
protected intmSize; //Size of undeleted(lazy undelete) boggys
protected LazySTBoggymRoot;
intmSizeHard; //real size of tree with lazy deleted boggys
    //constructor
public LazySearchTree() { clear(); }
public booleanempty() { return (mSize== 0); }
public intsize() { return mSize; }
public void clear() { mSize= 0; mRoot= null; }
public intshowHeight() { return findHeight(mRoot, -1); }

public String  sizeHard()
    {
return("hard size is :"+ mSizeHard);
    }

public E findMin()     //reimplement issue when the last one of the middle one is lolzzzz
{
if (mRoot== null)
throw new NoSuchElementException();
return findMin(mRoot).value;
    }

public E findMax()
    {
if (mRoot== null)
throw new NoSuchElementException();
return findMax(mRoot).value;
    }

public E find( E x )
    {
LazySTBoggyresultBoggy;
resultBoggy = find(mRoot, x);
if (resultBoggy == null)
throw new NoSuchElementException();
return resultBoggy.value;
    }
public booleancontains(E x)  { return find(mRoot, x) != null; }

public booleaninsert( E x )
    {
intoldSize = mSize;
mRoot= insert(mRoot, x);
return (mSize!= oldSize);
    }

public booleanremove( E x )
    {
intoldSize = mSize; //
mRoot= remove(mRoot, x);
return (mSize!= oldSize);
    }

public < F extends Traverser<? super E >>void traverseHard(F func)
    {
traverseHard(func, mRoot);
    }

public < F extends Traverser<? super E >>void traverseSoft(F func)
    {
traverseSoft(func, mRoot);
    }

public Object clone() throws CloneNotSupportedException
    {
LazySearchTree<E>newObject = (LazySearchTree<E>)super.clone();
newObject.clear();  // can't point to other's value

newObject.mRoot= cloneSubtree(mRoot);
newObject.mSize= mSize;

return newObject;
    }

// private helper methods ----------------------------------------
protected LazySTBoggyfindMin(LazySTBoggy root )
    {
if (root == null)
return null;
if (root.lftChild== null)
        {
if(root.deleted==false)
return root;
else
                return null;
        }
LazySTBoggy temp= findMin(root.lftChild);
if(temp==null)
return root;
else
            return temp;
    }

protected LazySTBoggyfindMax(LazySTBoggy root ) //reimplement
{
if (root == null)
return null;
if (root.rtChild== null)
        {
if(root.deleted==false)
return root;
else
                return null;
        }
LazySTBoggy temp= findMax(root.rtChild);
if(temp==null)
return root;
else
            return temp;
    }

protected LazySTBoggy insert(LazySTBoggy root, E x )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
        {
mSize++;
mSizeHard++;
return new LazySTBoggy(x, null, null);
        }

compareResult = x.compareTo(root.value);
if ( compareResult< 0 )
root.lftChild= insert(root.lftChild, x);
else if ( compareResult> 0 )
root.rtChild= insert(root.rtChild, x);
//if equal means same exist, so just turn it true
else if(root.deleted== true)
        {
root.deleted= false;
mSize++;
        }
//Should there be an case of equal and duplicate?
return root;
    }

protected LazySTBoggy remove(LazySTBoggy root, E x  )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
return null;

compareResult = x.compareTo(root.value);
if ( compareResult< 0 )
root.lftChild= remove(root.lftChild, x);
else if ( compareResult> 0 )
root.rtChild= remove(root.rtChild, x);

// found the boggy for lazy deletion
else
{
root.deleted= true;
mSize--;
        }
return root;
}

protected <F extends Traverser<? super E>>void traverseHard(F func, LazySTBoggytreeBoggy)
    {
if (treeBoggy == null)
return;

traverseHard(func, treeBoggy.lftChild);
func.visit(treeBoggy.value);
traverseHard(func, treeBoggy.rtChild);
    }

protected <F extends Traverser<? super E>>void traverseSoft(F func, LazySTBoggytreeBoggy)
    {
if (treeBoggy == null)
return;
traverseSoft(func, treeBoggy.lftChild);
if(treeBoggy.deleted==false)
func.visit(treeBoggy.value);
traverseSoft(func, treeBoggy.rtChild);
    }

protected LazySTBoggy find(LazySTBoggy root, E x )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
return null;

compareResult = x.compareTo(root.value);
if (compareResult< 0)
return find(root.lftChild, x);
if (compareResult> 0)
return find(root.rtChild, x);
if(root.deleted==false)
return root;   // found
else
            return null;   //not found as deleted

}

protected LazySTBoggycloneSubtree(LazySTBoggy root)
    {
LazySTBoggynewBoggy;
if (root == null)
return null;
newBoggy = new LazySTBoggy
                (
root.value,
cloneSubtree(root.lftChild),
cloneSubtree(root.rtChild)
                );
return newBoggy;
    }

protected intfindHeight(LazySTBoggytreeBoggy, intheight )
    {
intleftHeight, rightHeight;
if (treeBoggy == null)
return height;
        height++;
leftHeight = findHeight(treeBoggy.lftChild, height);
rightHeight = findHeight(treeBoggy.rtChild, height);
return (leftHeight>rightHeight)? leftHeight : rightHeight;
    }
public class LazySTBoggy
    {
public boolean deleted=false;
public LazySTBoggylftChild, rtChild;
public E value;
public LazySTBoggymyRoot;  // needed to test for certain error


public LazySTBoggy(E d, LazySTBoggylft, LazySTBoggyrt )
        {
lftChild= lft;
rtChild= rt;
value = d;
        }

public LazySTBoggy()
        {   this(null, null, null); }

public intgetHeight() { return 0; }
booleansetHeight(intheight) { return true; }
    }


}
