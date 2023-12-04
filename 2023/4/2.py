#!/usr/bin/env python3
import re
from functools import reduce

cards = {}


def find_number_of_matches(winning: list, yours: list) -> int:
    matches = 0
    for your_number in yours:
        if your_number in winning:
            matches += 1
    return matches


total = 0
for line in open('input.txt', 'r').readlines():
    line_raw = line.split(':')
    game_id = re.findall(r'(\d+)', line_raw[0])[0]
    if game_id not in cards.keys():
        cards[game_id] = 1
    game_raw = line_raw[1].split('|')
    winning_numbers = re.findall(r'(\d+)', game_raw[0].strip())
    your_numbers = re.findall(r'(\d+)', game_raw[1].strip())
    matches = find_number_of_matches(winning_numbers, your_numbers)
    for _ in range(cards[game_id]):
        for n in range(int(game_id) + 1, int(game_id) + 1 + matches):
            if str(n) not in cards.keys():
                cards[str(n)] = 1
            cards[str(n)] += 1

print(cards)

print(reduce((lambda x, y: x + y), cards.values()))
