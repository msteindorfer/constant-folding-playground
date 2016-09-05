/**
 * Copyright (c) Michael Steindorfer <Centrum Wiskunde & Informatica> and Contributors.
 * All rights reserved.
 *
 * This file is licensed under the BSD 2-Clause License, which accompanies this project
 * and is available under https://opensource.org/licenses/BSD-2-Clause.
 */
package com.github.msteindorfer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(1)
public class ConstantFoldingBenchmark {

	Random rand = new Random(157);	
	
	static final int STABLE_ARRAY_LENGTH = StableRootObject.INSTANCE.finalInstanceArrayField.length;
	static final int NON_STABLE_ARRAY_LENGTH = NonStableRootObject.INSTANCE.finalInstanceArrayField.length;

//	@Benchmark
//	public void timeNonStableField(Blackhole bh) {
//		
//		Class<?> clazz = NonStableRootObject.INSTANCE.getField();
//		bh.consume(clazz);
//	}
//	
//	@Benchmark
//	public void timeNonStableFinalField(Blackhole bh) {
//		
//		Class<?> clazz = NonStableRootObject.INSTANCE.getFinalField();
//		bh.consume(clazz);
//	}	
//	
//	@Benchmark
//	public void timeNonStableArray_Single(Blackhole bh) {
//
//		int slot = 1250;
//		Class<?> clazz = NonStableRootObject.INSTANCE.getFinalArrayField()[slot];
//
//		bh.consume(clazz);
//	}
//	
//	@Benchmark
//	public void timeNonStableArray_MultipleRandom(Blackhole bh) {
//
//		int slot = rand.nextInt(NON_STABLE_ARRAY_LENGTH);
//		Class<?> clazz = NonStableRootObject.INSTANCE.getFinalArrayField()[slot];
//
//		bh.consume(clazz);
//	}	

	@Benchmark
	public void timeField(Blackhole bh) {
		
		Class<?> clazz = StableRootObject.INSTANCE.getField();
		bh.consume(clazz);
	}
	
	@Benchmark
	public void timeFinalField(Blackhole bh) {
		
		Class<?> clazz = StableRootObject.INSTANCE.getFinalField();
		bh.consume(clazz);
	}	
	
	@Benchmark
	public void timeStableField(Blackhole bh) {
		
		Class<?> clazz = StableRootObject.INSTANCE.getStableField();
		bh.consume(clazz);
	}
	
	@Benchmark
	public void timeStableFinalField(Blackhole bh) {
		
		Class<?> clazz = StableRootObject.INSTANCE.getStableFinalField();
		bh.consume(clazz);
	}
	
	@Benchmark
	public void timeStableFinalArrayField_Single(Blackhole bh) {

		int slot = 1250;
		Class<?> clazz = StableRootObject.INSTANCE.getFinalArrayField()[slot];

		bh.consume(clazz);
	}
	
	@Benchmark
	public void timeStableFinalArrayField_Single_MultipleRandom(Blackhole bh) {

		int slot = rand.nextInt(STABLE_ARRAY_LENGTH);
		Class<?> clazz = StableRootObject.INSTANCE.getFinalArrayField()[slot];

		bh.consume(clazz);
	}
		
  public static void main(String[] args) throws RunnerException {
    System.out.println(ConstantFoldingBenchmark.class.getSimpleName());

    // @formatter:off
    Options opt = new OptionsBuilder()
        .include(".*" + ConstantFoldingBenchmark.class.getSimpleName() + ".*$")
        .timeUnit(TimeUnit.NANOSECONDS)
        .mode(Mode.AverageTime)
        .warmupIterations(10)
        .warmupTime(TimeValue.seconds(1))
        .measurementIterations(10)
        .forks(1)
        .build();
    // @formatter:on

    new Runner(opt).run();
  }

}
