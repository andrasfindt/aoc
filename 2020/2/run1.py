#!/usr/bin/env python3
import re

file1 = open('input.txt', 'r')
Lines = file1.readlines()
validCount = 0
for line in Lines:
    z = re.match("(\\d+)-(\\d+)\\s(\\w):\\s(\\w+)", line)
    lower = int(z.group(1))
    upper = int(z.group(2))
    char = z.group(3)
    password = z.group(4)
    count = 0
    for i in password:
        if i == char:
            count += 1
    if lower <= count <= upper:
        validCount += 1
print(validCount)
