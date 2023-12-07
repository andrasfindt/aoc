#!/usr/bin/env python3
input_string = open('input.txt', 'r').read().strip()

time_line, distance_line = input_string.split('\n')

time = [int(''.join(time_line.split(':')[1].split()))]
distance = [int(''.join(distance_line.split(':')[1].split()))]

total = 1

for i, t in enumerate(time):
    winning_times = []
    for n in range(1, 1 + t):
        dist = n * (t - n)
        if dist > distance[i]:
            winning_times.append(n)
    total *= len(winning_times)
print(total)
