//Team ComPairAble -- Leo Au-Yeung, Vincent Liok
//APCS1 pd10
//HW42 -- Array of Titanium
//2015-12-04

//ListInt will specify the capabilities of a list of ints
public interface ListInt {

	//adds an int after the last int
	void add ( Comparable newVal );

	//inserts an item at index
	//shifts existing ints to the right
	void add ( int index, Comparable newVal);

	//removes the item at index
	//shifts elements left to fill in newly-empted slot
	void remove ( int index);

	//return number of items in the list
	int size ();

	//accessor -- return value at specified index
	Comparable get (int index);

	//mutator -- set value at index to newVal, 
	//return old value at index
	Comparable set (int index, Comparable newVal);

}