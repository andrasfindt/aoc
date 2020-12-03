def do_run(x, y):
    file = open('input.txt', 'r')
    lines = file.readlines()
    tree_count = 0
    pos = 0
    for num, line in enumerate(lines):
        num += 1
        length = len(line.strip())
        line_list = list(line.strip())
        if (num + 1) % y == 0:
            if line_list[pos] == '#':
                tree_count += 1
                line_list[pos] = 'X'
            else:
                line_list[pos] = 'O'
            pos = (pos + x) % length
    return tree_count


print(do_run(1, 1) * do_run(3, 1) * do_run(5, 1) * do_run(7, 1) * do_run(1, 2))
