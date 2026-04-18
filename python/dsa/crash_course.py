def sum_of_even_numbers(numbers):
    total = 0
    for number in numbers:
        if number % 2 == 0:
            total += number
    return total

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def print_dictionary(my_dict):
    for key, value in my_dict.items():
        print(key, value)
