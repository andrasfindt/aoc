def get_count(line, pos):
    return line[pos] == '#', (pos + 3) % (len(line.strip()))


treeCount = 0
pos = 0
for line in open("input.txt", 'r').readlines():
    c, pos = get_count(line, pos)
    treeCount += c
print(treeCount)
