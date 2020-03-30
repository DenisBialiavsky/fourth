package model.logic;

public interface Storable<B> {
	void add(B b);

	void addAll(Storable<? extends B> b);

	void remove(int i);

	B get(int i);

	int size();

}
