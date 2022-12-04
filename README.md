# Advent of Code (2022)

Problems solutions of https://adventofcode.com in Java. 

## Initial Config

Execute this command to basic configuration: 
```bash
make start
```

## Generate new day

You can generate the basic classes to resolve a problem with that command: 
```bash
make new_day day=XX
```

If you generate a wrong day, you can execute:
```bash
make remove_day day=XX
```

## Execute tests

You can use your favourite IDE or this commands:

For one test:
```bash
make test day=XX
```
For all tests:
```bash
make all_tests
```

## Format and check format

It is a good practice format your code because is less common generate conflict in the same classes. You can format your code with prettier with this command:

```bash
make format
```

And check if others pass prettier in their code.
```bash
make check_format
```

There are git hooks with those two command in the commit and push actions.



