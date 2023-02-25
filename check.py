import math

def function(x : int) -> float:
    return pow(x - 1,2)

def bisection(a,b,point) -> float:     
    while True:
        xm = (a + b)/2
        L = b - a
        x1 = a + L/4
        x2 = b - L/4    

        f_xm = function(xm)
        f_x1 = function(x1)
        f_x2 = function(x2)

        if f_x1 < f_xm:
            b = xm
            xm = x1

        if f_x1 > f_xm:        
            if f_x2 < f_xm :
                a = xm
                xm = x2
            if f_x2 > f_xm:
                a = x1
                b = x2            

        L = b - a 

        if L < point:
            return xm
            break

def gold_ratio(a,b,e) -> float:
    ratio = (-1 + math.sqrt(5))/2
    t1 = 1 - ratio
    x0 = a 
    x3 = b 
    x1 = a + t1*(b-a)
    x2 = a + t1*(b-a)
    f_x1 = function(x1)
    f_x2 = function(x2)

    while True :
        
        if f_x1 > f_x2:
            L = x3 - x1
            x0 = x1 
            x1 = x2
            x2 = x0 + t1 * L
            f_x1 = f_x2
            f_x2 = function(x2)
        else:
            L = x2 - x0
            x3 = x2
            x2 = x1
            x1 = x0 + t1 * L
            f_x2 = f_x1
            f_x1 = function(x1)

        if abs(L) < e :
            break

    x = (x0+x3)/2
    R = function(x)          
    
    print(x,"   ",R)
    
a = float(input())
b = float(input())

print("Bisection: " , bisection(a,b,0.01))
gold_ratio(a,b,0.01)