#!/usr/bin/env python3
import re


def validate_byr(val):
    valid = 1920 <= int(val) <= 2002
    if DEBUG and not valid:
        print("byr", val)
    return valid


def validate_iyr(val):
    valid = 2010 <= int(val) <= 2020
    if DEBUG and not valid:
        print("iyr", val)
    return valid


def validate_eyr(val):
    valid = 2020 <= int(val) <= 2030
    if DEBUG and not valid:
        print("eyr", val)
    return valid


def validate_hgt(val):
    valid = False
    match_cm = re.match("(\\d+)cm", val)
    if match_cm:
        valid = 150 <= int(match_cm.group(1)) <= 193
    match_in = re.match("(\\d+)in", val)
    if match_in:
        valid = 59 <= int(match_in.group(1)) <= 76
    if DEBUG and not valid:
        print("hgt", val)
    return valid


def validate_hcl(val):
    valid = bool(re.match("#[0-9a-f]{6}", val))
    if DEBUG and not valid:
        print("hcl", val)
    return valid


def validate_ecl(val):
    valid = val in ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"]
    if DEBUG and not valid:
        print("ecl", val)
    return valid


def validate_pid(val):
    valid = bool(re.match("\\d{9}", val))
    if DEBUG and not valid:
        print("pid", val)
    return valid


DEBUG = False

functions = locals()
required_fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"}

file = open('input.txt', 'r')
valid_count = 0
passports = file.read().replace("\r", "").replace("\n\n", "|").replace("\n", " ").split("|")
for passport in passports:
    print(passport)
    field_validity = []
    for x in passport.split(' '):
        k, v = x.split(':')
        if k not in required_fields:
            continue
        field_validity.append((k, functions["validate_" + k](v)))
    keys_present = [i[0] for i in field_validity]
    all_fields_valid = (not (False in [i[1] for i in field_validity]))
    missing_fields = list(set(keys_present) ^ required_fields)
    if not missing_fields and all_fields_valid is True:
        valid_count += 1
print(valid_count)
