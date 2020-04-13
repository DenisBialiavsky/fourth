package model.logic;

import java.util.Iterator;

public interface Storable<B> extends Iterable{
	void add(B b);

	void addAll(Storable<? extends B> b);

	void remove(int i);

	B get(int i);

	int size();
	
	void set(int index, B elem);
	
	public default Iterator iterator() {
		return new StorableIterator((Storable<Object>) this);
	}

}
