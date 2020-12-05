print(max([int(boarding_pass, 2) for boarding_pass in open('input.txt', 'r').read().replace("F", "0").replace("B", "1").replace("R", "1").replace("L", "0").split("\n")]))
