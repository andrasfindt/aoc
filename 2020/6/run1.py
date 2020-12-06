print(sum([len(set(customs_form.strip())) for customs_form in open('input.txt', 'r').read().replace("\n\n", "|").replace("\n", "").split("|") if customs_form]))
