#!/usr/bin/env python3
import re

input_string = open('input.txt', 'r').read().strip()

time_line, distance_line = input_string.split('\n')

time = [int(x) for x in time_line.split(':')[1].split()]
distance = [int(x) for x in distance_line.split(':')[1].split()]

total = 1

for i, t in enumerate(time):
    winning_times = []
    for n in range(1, 1 + t):
        dist = n * (t - n)
        if dist > distance[i]:
            winning_times.append(n)
    total *= len(winning_times)
print(total)
