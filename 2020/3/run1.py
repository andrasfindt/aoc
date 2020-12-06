file1 = open('input.txt', 'r')
Lines = file1.readlines()

treeCount = 0
pos = 0
for line in Lines:
    treeCount += line[pos] == '#'
    pos = (pos + 3) % (len(line.strip()))
print(treeCount)
