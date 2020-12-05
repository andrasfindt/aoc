#!/usr/bin/env python3

# byr (Birth Year)
# iyr (Issue Year)
# eyr (Expiration Year)
# hgt (Height)
# hcl (Hair Color)
# ecl (Eye Color)
# pid (Passport ID)
# cid (Country ID)

required_fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"}

file = open('input.txt', 'r')
passports = file.read().replace("\r", "").replace("\n\n", "|").replace("\n", " ").split("|")
valid_count = 0

for passport in passports:
    num_fields_present = 0
    keys_present = []
    for x in passport.split(' '):
        k, v = x.split(':')
        if k not in required_fields:
            continue
        keys_present.append(k)
    missing_fields = list(set(keys_present) ^ required_fields)
    if not missing_fields:
        valid_count += 1
print(valid_count)
