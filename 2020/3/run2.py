def do_run(x, y):
    tree_count = 0
    pos = 0
    for num, line in enumerate(open('input.txt', 'r').readlines()):
        num += 1
        line_list = list(line.strip())
        if (num + 1) % y == 0:
            tree_count += line_list[pos] == '#'
            pos = (pos + x) % len(line.strip())
    return tree_count


print(do_run(1, 1) * do_run(3, 1) * do_run(5, 1) * do_run(7, 1) * do_run(1, 2))
