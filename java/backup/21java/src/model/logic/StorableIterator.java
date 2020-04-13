package model.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StorableIterator implements Iterator{
	
	private Storable<Object> ms;
	private int position;
	

	public StorableIterator(Storable<Object> ms) {
		this.ms = ms;	
	}

	@Override
	public boolean hasNext() {
		return (position) < ms.size();
	}

	@Override
	public Object next() {
		return ms.get(position++);
	}

}
