groups = open('input.txt', 'r').read().replace("\n\n", "|").replace("\n", " ").split("|")
valid_forms_count = []
for group in groups:
    if group:
        forms = [set(form) for form in group.split(" ")]
        intersection = forms[0]
        for form in forms:
            intersection = intersection.intersection(form) # this is probably a bit expensive...
        valid_forms_count.append(len(intersection))
print(sum(valid_forms_count))
