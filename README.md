# Stack machine

After brushing up on the [Java Virtual Machine Bytecode implementation ](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html) i was inspired to write a stack based interpreter

first step to get something to work so chose [postfix (reverse polish notation)](https://en.wikipedia.org/wiki/Reverse_Polish_notation) which is a truly brilliant expression language in its simplicity

but i also want to allow infix expressions, and possibly use [Pratt parsing](https://matklad.github.io/2020/04/13/simple-but-powerful-pratt-parsing.html)
# initial implemetatino postfix notation

# to run

```bash
java -jar build/libs/stackmach-1.0.0.jar "2 3 4 + -"
```

