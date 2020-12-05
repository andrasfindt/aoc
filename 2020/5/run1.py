file = open('input.txt', 'r')
boarding_passes = file.read().replace("F", "0").replace("B", "1").replace("R", "1").replace("L", "0").split("\n")

pass_ids = []
for boarding_pass in boarding_passes:
    # the commented out code below follows the wording of the task,
    # but it is simply a convoluted way of turning the pass value
    # into a 10 bit number:
    # row = int(boarding_pass[0:7], 2)
    # col = int(boarding_pass[7:10], 2)
    # pass_ids.append(row * 8 + col)
    pass_ids.append(int(boarding_pass, 2))
print(max(pass_ids))
