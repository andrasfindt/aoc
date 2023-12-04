#!/usr/bin/env python3
import re

total = 0
for line in open('input.txt', 'r').readlines():
    line_raw = line.split(':')
    game_id = line_raw[0].split(' ')[1]
    print(f'game {game_id}:')
    game_raw = line_raw[1].split('|')
    winning_numbers = re.findall(r'(\d+)', game_raw[0].strip())
    your_numbers = re.findall(r'(\d+)', game_raw[1].strip())
    print(winning_numbers)
    print(your_numbers)
    game_score = 0
    for your_number in your_numbers:
        if your_number in winning_numbers:
            if game_score == 0:
                game_score = 1
            else:
                game_score *= 2
    print(game_score)
    total += game_score
print(total)
