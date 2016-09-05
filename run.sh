# export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.9.0.jdk/Contents/Home 

# mvn clean package
java -Xbootclasspath/p:/Users/Michael/Development/constant-folding-playgroundtarget/constant-folding-playground-0.0.1-SNAPSHOT.jar \
	-XX:+TieredCompilation \
	-XX:+UseCompressedOops \
	\
	-XX:+UnlockExperimentalVMOptions \
	-XX:+TrustFinalNonStaticFields \
	\
	-XX:+UnlockDiagnosticVMOptions \
	-XX:+FoldStableValues \
	-XX:+UseImplicitStableValues \
	\
	-XX:+TraceClassLoading \
	-XX:+LogCompilation \
	-XX:+PrintAssembly \
	\
	-jar target/benchmarks.jar -f 0 -wi 5 -i 10 ".*Field$"

	# -XX:+TraceClassLoading \
	# -XX:+LogCompilation \
	# -XX:+PrintAssembly \
	# \

	# -XX:+TraceClassLoading \
	# -XX:+LogCompilation \
	# -XX:+PrintAssembly \
	# -Xlog:help \
	# -Xlog:class+load=info:file=run.log:none \
	# \

# http://hg.openjdk.java.net/jdk9/jdk9/hotspot/rev/3637ec3e50c2
	# -Xlog:classload=info
	# [0.005s][warning][arguments] -XX:+TraceClassLoading is deprecated. Will use -Xlog:class+load=info instead.