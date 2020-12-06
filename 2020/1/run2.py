from functools import reduce

lines = open('input.txt', 'r').readlines()
for line_a in lines:
    for line_b in lines:
        for line_c in lines:
            values = [int(line_a), int(line_b), int(line_c)]
            if sum(values) == 2020:
                print(reduce((lambda x, y: x * y), values))
                exit(0)
