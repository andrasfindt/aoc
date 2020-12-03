file1 = open('input.txt', 'r')
Lines = file1.readlines()

treeCount = 0
pos = 0
for line in Lines:
    length = len(line) - 1
    print(length)
    if line[pos] == '#':
        treeCount += 1
    pos = (pos + 3) % length
print(treeCount)
