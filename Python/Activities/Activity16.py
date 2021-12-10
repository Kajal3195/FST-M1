#Class of Cars
class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Hyundayi", "Grandi10", "2015", "Manual", "Red")
car2 = Car("Maruti", "Wagonar", "2013", "Manual", "Grey")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "White")

car1.accelerate()
car1.stop()