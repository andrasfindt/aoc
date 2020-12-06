print(sum([len(set.intersection(*[set(form) for form in group.split(" ")])) for group in open('input.txt', 'r').read().replace("\n\n", "|").replace("\n", " ").split("|")]))
