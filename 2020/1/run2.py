lines = open('input.txt', 'r').readlines()
for line_a in lines:
    for line_b in lines:
        for line_c in lines:
            if int(line_a) + int(line_b) + int(line_c) == 2020:
                print(int(line_a) * int(line_b) * int(line_c))
                exit(0)
