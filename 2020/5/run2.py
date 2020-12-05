pass_ids = [int(boarding_pass, 2) for boarding_pass in
            open('input.txt', 'r').read()
                .replace("F", "0")
                .replace("B", "1")
                .replace("R", "1")
                .replace("L", "0")
                .split("\n") if boarding_pass]

all_ids = set(range(min(pass_ids), max(pass_ids) + 1))
missing_ids = all_ids ^ set(pass_ids)
print(missing_ids)
