#!/usr/bin/env python3
import re

COL_WIDTH = 140


def clamp(num, clamp_value):
    if num < 0:
        return 0
    if num > clamp_value:
        return clamp_value
    return num


def adjacent_to_symbol(lines, row_index, col_span):
    col_width = len(lines[row_index])
    col_start = clamp(col_span[0] - 1, col_width)
    col_end = clamp(col_span[1] + 1, col_width)
    row_start = clamp(row_index - 1, len(lines))
    row_end = clamp(row_index + 2, len(lines))
    print(f"({row_start},{col_start}) - ({row_end},{col_end})")
    match_found = False
    for row in range(row_start, row_end):
        substring = lines[row].strip()[col_start:col_end]
        print(substring)
        if re.match(r'.*[^.\d]+.*', substring):
            match_found = True
    if match_found:
        print('match found')
    return match_found


total = 0
lines = open('input.txt', 'r').readlines()
for line_index in range(len(lines)):
    print(f'line {line_index}:')
    line = lines[line_index].strip()
    # print(line)
    matches = re.finditer(r'(\d+)', line)
    for match in matches:
        span = match.span()
        num = int(match.group())
        print(f"{span} {num}")
        if adjacent_to_symbol(lines, line_index, span):
            total += num
    print('----------')
print(f"{total}")
