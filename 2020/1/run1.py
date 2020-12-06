lines = open('input.txt', 'r').readlines()
for line_a in lines:
    for line_b in lines:
        if int(line_a) + int(line_b) == 2020:
            print(int(line_a) * int(line_b))
            exit(0)
