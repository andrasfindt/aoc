#!/usr/bin/env python3
import re

file1 = open('input.txt', 'r')
Lines = file1.readlines()
validCount = 0
for line in Lines:
    z = re.match("(\\d+)-(\\d+)\\s(\\w):\\s(\\w+)", line)
    pos1 = int(z.group(1)) - 1
    pos2 = int(z.group(2)) - 1
    char = z.group(3)
    password = z.group(4)
    count = 0
    if password[pos1] == char:
        count += 1
    if password[pos2] == char:
        count += 1
    if count == 1:
        validCount += 1
print(validCount)
