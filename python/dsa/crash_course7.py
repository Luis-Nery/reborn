"""
OOP Crash Course — Encapsulation & Polymorphism
"""

# ── ENCAPSULATION ──────────────────────────────────────
# Bundling data (attributes) + behaviour (methods) into one class.
# Private attributes use __ prefix — outsiders can't touch them directly.

class BankAccount:
    def __init__(self, owner: str, balance: float = 0):
        self.owner = owner          # public
        self.__balance = balance    # private — hidden from outside

    def deposit(self, amount: float):
        if amount > 0:
            self.__balance += amount
            print(f"  Deposited ${amount:.2f}")

    def withdraw(self, amount: float):
        if amount > self.__balance:
            print("  Insufficient funds!")
        else:
            self.__balance -= amount
            print(f"  Withdrew ${amount:.2f}")

    def get_balance(self) -> float:   # controlled read access
        return self.__balance

    def __str__(self):
        return f"[{self.owner}] Balance: ${self.__balance:.2f}"


# ── POLYMORPHISM ───────────────────────────────────────
# Same method name, different behaviour depending on the class.
# Here every Animal has speak(), but each one does it differently.

class Animal:
    def __init__(self, name: str):
        self.name = name

    def speak(self) -> str:
        raise NotImplementedError("Subclass must implement speak()")

    def __str__(self):
        return f"{self.__class__.__name__}({self.name})"


class Dog(Animal):
    def speak(self) -> str:
        return f"{self.name} says: Woof! 🐶"

class Cat(Animal):
    def speak(self) -> str:
        return f"{self.name} says: Meow! 🐱"

class Duck(Animal):
    def speak(self) -> str:
        return f"{self.name} says: Quack! 🦆"


# ── DEMO ───────────────────────────────────────────────
if __name__ == "__main__":

    print("=== Encapsulation ===")
    acc = BankAccount("Alice", 100)
    acc.deposit(50)
    acc.withdraw(200)           # blocked
    acc.withdraw(30)
    print(acc)
    # print(acc.__balance)      # ← would crash — it's private!

    print("\n=== Polymorphism ===")
    animals: list[Animal] = [Dog("Rex"), Cat("Luna"), Duck("Donald")]

    # Same loop, same method call — three totally different results
    for animal in animals:
        print(" ", animal.speak())