package com.github.msteindorfer;

//import jdk.internal.vm.annotation.Stable;
import java.lang.invoke.Stable;

public class StableRootObject {
	
	@Stable
	public final static StableRootObject INSTANCE = new StableRootObject();


	
	Class<?> instanceField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	Class<?>[] instanceArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getField() {
		return instanceField;
	}
	
	public final Class<?>[] getArrayField() {
		return instanceArrayField;
	}	

	
	
	@Stable
	Class<?> stableField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	@Stable
	Class<?>[] stableArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getStableField() {
		return stableField;
	}
	
	public final Class<?>[] getStableArrayField() {
		return stableArrayField;
	}	

	
	
	final Class<?> finalInstanceField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	final Class<?>[] finalInstanceArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getFinalField() {
		return finalInstanceField;
	}
	
	public final Class<?>[] getFinalArrayField() {
		return finalInstanceArrayField;
	}	
	
	

	@Stable
	final Class<?> stableFinalField = com.github.msteindorfer.Specializations.SetMultimap11To22Node.class;
	
	@Stable
	final Class<?>[] stableFinalArrayField = Util.initializeSpecializationsByContentAndNodes();
	
	public final Class<?> getStableFinalField() {
		return stableFinalField;
	}
	
	public final Class<?>[] getStableFinalArrayField() {
		return stableFinalArrayField;
	}
	
}
