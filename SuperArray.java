//Team ComPairAble - Leo Auyeung, Vincent Liok
//APCS1 pd10
//HW42 -- Array of Titanium
//2015-12-04

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements ListInt{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	expand(); // make sure _data is large enough for the addition
	set( _lastPos + 1, newVal );
	_lastPos += 1;
	_size += 1;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	expand();
	for( int i = _lastPos; i >= index; i-- ) {
	    _data[i + 1] = _data[i]; // shifts every element one slot to the right from the right
	}
	set( index, newVal );
	_lastPos += 1;
	_size += 1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	for ( int i = index; i <= _lastPos; i++ ) {
	    _data[i - 1] = _data[i];
	}
	set( _lastPos, null );
	_lastPos -= 1;
	_size -= 1;
    }

    public int linSearch( Comparable o ) {
	int ans = -1;
	for ( int index = 0 ; index < _size ; index++ ) {
	    if ( o.equals(_data[index]) ) {
		return ans;
	    }
	}
	return ans;
    }

    public boolean isSorted() {
	for ( int index = 0 ; index < _size ; index++ ) {
	    if ( _data[index].compareTo(_data[index+1]) > 0 ) {
		return false;
	    }
	}
	return true;
    }

    //return number of meaningful items in _data
    public int size() { return _size; }
    

    //main method for testing
    public static void main( String[] args ) {
	
	
    }//end main
		
}//end class
