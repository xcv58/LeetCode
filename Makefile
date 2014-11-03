SRC_JAVA = $(shell find . -name *.java)
SRC_C = $(shell find . -name *.cpp)

TARGET_JAVA = $(SRC_JAVA:%.java=%.class)
TARGET_OBJ = $(SRC_C:%.cpp=%.o)
TARGET_BIN = $(SRC_C:%.cpp=%.bin)

all: $(TARGET_JAVA) $(TARGET_OBJ) $(TARGET_BIN)

%.class: %.java
	javac -classpath $(shell dirname $<) $<

%.o: %.c
	gcc -c $<

%.bin: %.o
	gcc $< -o $@

clean:
	rm -f $(TARGET_JAVA)
	rm -f $(TARGET_OBJ)
	rm -f $(TARGET_BIN)
