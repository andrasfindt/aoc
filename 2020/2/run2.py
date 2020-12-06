#!/usr/bin/env python3
import re


def get_validity(z):
    return (z.group(4)[int(z.group(1)) - 1] == z.group(3)) ^ (z.group(4)[int(z.group(2)) - 1] == z.group(3))


print(sum([get_validity(re.match("(\\d+)-(\\d+)\\s(\\w):\\s(\\w+)", line)) for line in open('input.txt', 'r').readlines() if line]))
