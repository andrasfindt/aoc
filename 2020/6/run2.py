print(sum([len(set.intersection(*[set(form) for form in group.split("\n")])) for group in open('input.txt', 'r').read().split("\n\n") if group]))
