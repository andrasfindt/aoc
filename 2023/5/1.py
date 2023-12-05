#!/usr/bin/env python3
import re


def parse_section(name, source):
    re_iter = re.finditer(name + r' map:\s+(?:(\d+ \d+ \d+)\s)+', source)
    result = {'name': name}
    section = None
    for n in re_iter:
        section = n.group().strip().split('\n')[1::]
    mappings = []
    for mapping in section:
        m = list(map(int, mapping.split(' ')))
        mappings.append(tuple(m))
    result['mappings'] = mappings
    return result


def find_in_section(item, section):
    for mapping in section['mappings']:
        dst = mapping[0]
        src = mapping[1]
        rng = mapping[2]
        if item in range(src, src + rng):
            return (dst - src) + item
    return item


total = 0xffffffffffffffff
lines = open('input.txt', 'r').readlines()
seed_line = lines.pop(0)
lines.pop(0)
seeds = list(map(int, re.findall(r"\d+", seed_line)))

s = "".join(lines)

seed_to_soil = parse_section('seed-to-soil', s)
soil_to_fertilizer = parse_section('soil-to-fertilizer', s)
fertilizer_to_water = parse_section('fertilizer-to-water', s)
water_to_light = parse_section('water-to-light', s)
light_to_temperature = parse_section('light-to-temperature', s)
temperature_to_humidity = parse_section('temperature-to-humidity', s)
humidity_to_location = parse_section('humidity-to-location', s)

print(seeds)
print(seed_to_soil)
print(soil_to_fertilizer)
print(fertilizer_to_water)
print(water_to_light)
print(light_to_temperature)
print(temperature_to_humidity)
print(humidity_to_location)

for seed in seeds:
    soil = find_in_section(seed, seed_to_soil)
    fertilizer = find_in_section(soil, soil_to_fertilizer)
    water = find_in_section(fertilizer, fertilizer_to_water)
    light = find_in_section(water, water_to_light)
    temperature = find_in_section(light, light_to_temperature)
    humidity = find_in_section(temperature, temperature_to_humidity)
    location = find_in_section(humidity, humidity_to_location)

    print(
        f"Seed {seed}, soil {soil}, fertilizer {fertilizer}, water {water}, light {light}, temperature {temperature}, humidity {humidity}, location {location}")
    total = min(total, location)
print(total)
