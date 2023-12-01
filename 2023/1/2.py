#!/usr/bin/env python3
import re
digit_mapping = {'one': 1, 'two': 2, 'three': 3, 'four': 4, 'five': 5, 'six': 6, 'seven': 7, 'eight': 8, 'nine': 9}

m_pattern = r'\d|' + '|'.join(digit_mapping.keys())
n_pattern = r'\d|' + '|'.join(digit_mapping.keys())[::-1]


def get_digit(val):
    if val in digit_mapping.keys():
        return digit_mapping[val]
    else:
        return val


total = 0
for line in open('input.txt', 'r').readlines():
    m = re.findall(m_pattern, line)
    n = re.findall(n_pattern, line[::-1])
    if m and n:
        total += int(f"{get_digit(m[0])}{get_digit(n[0][::-1])}")
print(total)
