def palindrome_check(string):
    return string == string[::-1]

def list_intersection(list1, list2):
    set1 = set(list1)
    set2 = set()
    for item in list2:
        if item in set1:
            set2.add(item)
    return set2
from collections import deque
class Queue:
    def __init__(self):
        self.items = deque()
    def enqueue(self, item):
        self.items.appendleft(item)

    def dequeue(self):
        return self.items.popleft()

    def peek(self):
        return self.items[0]

    def is_empty(self):
        return len(self.items) == 0



