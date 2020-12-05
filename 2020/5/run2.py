file = open('input.txt', 'r')
boarding_passes = file.read().replace("F", "0").replace("B", "1").replace("R", "1").replace("L", "0").split("\n")

pass_ids = []
for boarding_pass in boarding_passes:
    pass_ids.append(int(boarding_pass, 2))

all_ids = set(range(min(pass_ids), max(pass_ids) + 1))
missing_ids = list(all_ids ^ set(pass_ids))

print(missing_ids)
