package com.github.msteindorfer;

public class NonStableRootObject {

	public final static StableRootObject INSTANCE = new StableRootObject();

	
	
	Class<?> instanceField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	Class<?>[] instanceArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getField() {
		return instanceField;
	}
	
	public final Class<?>[] getArrayField() {
		return instanceArrayField;
	}	

	
	
	final Class<?> finalInstanceField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	final Class<?>[] finalInstanceArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getFinalField() {
		return finalInstanceField;
	}
	
	public final Class<?>[] getFinalArrayField() {
		return finalInstanceArrayField;
	}	
	
}