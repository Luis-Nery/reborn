# python_notes.py - Python tricks and shortcuts

# Reverse a string
name = "Luis"
print(name[::-1])  # siuL

# Reverse a list
nums = [1, 2, 3, 4, 5]
print(nums[::-1])  # [5, 4, 3, 2, 1]

# Last element
print(nums[-1])  # 5

# Last 3 elements
print(nums[-3:])  # [3, 4, 5]

# Every other element
print(nums[::2])  # [1, 3, 5]

# List comprehension
squares = [x**2 for x in range(10)]
print(squares)  # [0, 1, 4, 9, 16...]

# Swap two variables
a, b = 1, 2
a, b = b, a

# Check if string is palindrome
word = "racecar"
print(word == word[::-1])  # True

# Flatten a list
nested = [[1,2],[3,4],[5,6]]
flat = [x for row in nested for x in row]
print(flat)  # [1, 2, 3, 4, 5, 6]

# Count occurrences
letters = ['a','b','a','c','a']
print(letters.count('a'))  # 3