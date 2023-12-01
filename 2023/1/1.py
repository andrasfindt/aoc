#!/usr/bin/env python3
import re

total = 0
for line in open('input.txt', 'r').readlines():
    m = re.findall(r"\d", line)
    if m:
        total += int(f"{m[0]}{m[len(m) - 1]}")
print(total)
