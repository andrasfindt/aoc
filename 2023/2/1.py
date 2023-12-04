#!/usr/bin/env python3

cubes = {'red': 12, 'green': 13, 'blue': 14}
total = 0
for line in open('input.txt', 'r').readlines():
    game = line.strip().split(': ')
    game_num = int(game[0].split(' ')[1])
    print(f"Game {game_num}:")
    game_possible = True
    for reveals in game[1].split('; '):
        for reveal in reveals.split(', '):
            num = int(reveal.split(' ')[0])
            col = reveal.split(' ')[1]
            if num > cubes[col]:
                print(f"{num} {col} ***")
                game_possible = False
            else:
                print(f"{num} {col}")
        print(f"------")
    if game_possible:
        total += game_num
print(total)
