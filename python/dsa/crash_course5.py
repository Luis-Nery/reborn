class Mammal:
    def __init__(self, hasHair):
        self.hasHair = True

    def get_hair(self):
        return self.hasHair

    def speak(self):
        print(f"I have hair!")

class Dog(Mammal):
    def __init__(self, hasHair=True,hasFourLegs=True):
        super().__init__(hasHair)
        self.hasFourLegs = True


my_dog = Dog()
my_dog.speak()