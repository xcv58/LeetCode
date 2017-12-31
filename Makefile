SRC_JAVA = $(shell find . -name *.java)
SRC_CPP = $(shell find . -name *.cpp)
SRC_C = $(shell find . -name *.c)

TARGET_JAVA = $(SRC_JAVA:%.java=%.class)
TARGET_OBJ = $(SRC_CPP:%.cpp=%.obj)
TARGET_O = $(SRC_C:%.c=%.o)

all: $(TARGET_O) $(TARGET_OBJ)

%.class: %.java
	javac -classpath $(shell dirname $<) $<

%.o: %.c
	gcc -c $< -o $@

%.obj: %.cpp
	gcc -c $< -o $@

clean:
	rm -f $(TARGET_JAVA)
	rm -f $(TARGET_O)
	rm -f $(TARGET_OBJ)

todo:
	@ag -g "cpp|py|java" | sed -e 's/\/.*//' | sort | uniq -c | sort | ag "^\s*[12]"

commited:
	@git ls-files --directory | grep "/" | sed "s/\/.*//" | sort | uniq
	@git ls-files --directory | grep "/" | sed "s/\/.*//" | sort | uniq | wc -l

uncommit:
	@(ag -g "cpp|py|java" | sed -e 's/\/.*//' | sort | uniq; git ls-files --directory | grep "/" | sed "s/\/.*//" | sort | uniq) | sort | uniq -u
	@(ag -g "cpp|py|java" | sed -e 's/\/.*//' | sort | uniq; git ls-files --directory | grep "/" | sed "s/\/.*//" | sort | uniq) | sort | uniq -u | wc -l

total:
	@ag -g "cpp|py|java" | sed -e 's/\/.*//' | sort | uniq | sort | uniq -u
	@ag -g "cpp|py|java" | sed -e 's/\/.*//' | sort | uniq | sort | uniq -u | wc -l
