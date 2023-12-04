#!/usr/bin/env python3
import re

MAX_NUMBER_LENGTH = 3


def clamp(num, clamp_value):
    if num < 0:
        return 0
    if num > clamp_value:
        return clamp_value
    return num


def adjacent_to_symbol(col_span):
    asterisk_index = 3
    if col_span[0] <= asterisk_index + 1 and col_span[1] >= asterisk_index:
        print('match found')
        return True
    return False


def get_search_space(lines, row_index, col_span):
    col_width = len(lines[row_index])
    col_start = clamp(col_span[0] - MAX_NUMBER_LENGTH, col_width)
    col_end = clamp(col_span[1] + MAX_NUMBER_LENGTH, col_width)
    row_start = clamp(row_index - 1, len(lines))
    row_end = clamp(row_index + 2, len(lines))
    print(f"({row_start},{col_start}) - ({row_end},{col_end})")
    search_lines = []
    for row in range(row_start, row_end):
        substring = lines[row].strip()[col_start:col_end]
        print(substring)
        search_lines.append(substring)

    return search_lines


total = 0
lines = open('input.txt', 'r').readlines()
for line_index in range(len(lines)):
    print(f'line {line_index}:')
    line = lines[line_index].strip()
    # print(line)
    matches = re.finditer(r'\*', line)
    for match in matches:
        span = match.span()
        num = match.group()
        print(f"{span[0]} {num}")

        search_lines = get_search_space(lines, line_index, span)

        gears = []
        for search_line in search_lines:
            # print(line)
            numbers = re.finditer(r'(\d+)', search_line)
            for number in numbers:
                span = number.span()
                num = int(number.group())
                print(f"{span} {num}")
                if adjacent_to_symbol(span):
                    gears.append(num)
        if len(gears) == 2:
            print(f'{gears[0]} * {gears[1]} = {gears[0] * gears[1]}')
            total += gears[0] * gears[1]
        print('----------')
    print('----------')
print(f"{total}")
