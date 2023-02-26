
import math

def function(x):
    return x * math.sin(3*x) * math.cos(x)

def min_max(a,b,step):        
    current = a

    max = -99999
    min = 99999

    while current <= b :
        y = function(current)
        if y > max :
            max = y
        if y < min :
            min = y
        current += step

        print("Current max ", max)
        print("Current min ", min)

    print("Max ", max)
    print("Min ", min)

a = float(input())
b = float(input())
step = float(input())

min_max(a,b,step)