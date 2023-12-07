#!/usr/bin/env python3
from functools import cmp_to_key

input_string = open('input.txt', 'r').read().strip()

card_ranks = {'A': 12, 'K': 11, 'Q': 10, 'J': 0, 'T': 9, '9': 8, '8': 7, '7': 6, '6': 5, '5': 4, '4': 3, '3': 2, '2': 1}


def apply_jokers(card_counts: dict[str, int]):
    # this is obviously pretty dumb but totally works.
    # better would probably be to sort the dict by value (desc)
    # and add the joker count on the first non-joker.
    # anyway, shippit.
    if 'J' in card_counts.keys():
        max_card = None
        max_count = 0
        for card in card_counts.keys():
            if card == 'J':
                continue
            else:
                card_ = card_counts[card]
                if card_ > max_count:
                    max_card = card
                    max_count = card_
        card_counts[max_card] = max_count + card_counts["J"]
        del card_counts["J"]


def determine_hand_type(hand: list[str]):
    hand_type = 1
    card_counts = {}
    for card in hand:
        if card not in card_counts.keys():
            card_counts[card] = hand.count(card)
    apply_jokers(card_counts)

    vals = card_counts.values()
    if 5 in vals:
        hand_type = 7
    elif 4 in vals:
        hand_type = 6
    elif 3 in vals and 2 in vals:
        hand_type = 5
    elif 3 in vals:
        hand_type = 4
    elif list(vals).count(2) > 1:
        hand_type = 3
    elif 2 in vals:
        hand_type = 2
    return hand_type


def compare_ranks(x: dict, y: dict):
    if x['hand_type'] == y['hand_type']:
        for i in range(5):
            x_hand_i = card_ranks[x['hand'][i]]
            y_hand_i = card_ranks[y['hand'][i]]
            if x_hand_i == y_hand_i:
                continue
            else:
                return x_hand_i - y_hand_i
    else:
        return x['hand_type'] - y['hand_type']


def __main__():
    hands = []
    total = 0
    for line in input_string.split('\n'):
        hand, bid = line.split()
        hand = [*hand]
        hand_type = determine_hand_type(hand)
        hands.append({'hand': hand, 'bid': int(bid), 'hand_type': hand_type})
    sorted_list = sorted(hands, key=cmp_to_key(compare_ranks))

    for i, hand in enumerate(sorted_list, start=1):
        total += i * hand['bid']
    print(total)


__main__()
