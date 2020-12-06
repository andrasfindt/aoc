print(sum([len(set(customs_form)) for customs_form in open('input.txt', 'r').read().split("\n\n") if customs_form]))
