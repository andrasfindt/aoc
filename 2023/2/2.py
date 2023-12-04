#!/usr/bin/env python3

total = 0
for line in open('input.txt', 'r').readlines():
    cubes = {'red': 0, 'green': 0, 'blue': 0}
    game = line.strip().split(': ')
    game_num = int(game[0].split(' ')[1])
    print(f"Game {game_num}:")
    for reveals in game[1].split('; '):
        for reveal in reveals.split(', '):
            num = int(reveal.split(' ')[0])
            col = reveal.split(' ')[1]
            cubes[col] = max(cubes[col], num)
    print(f"{cubes}")
    total += cubes['red'] * cubes['green'] * cubes['blue']
    print(f"------")
print(total)
